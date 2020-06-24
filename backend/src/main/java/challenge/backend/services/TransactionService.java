package challenge.backend.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import challenge.backend.data.TransactionDao;
import challenge.backend.models.Transaction;
import challenge.backend.models.TransactionSum;
import challenge.backend.models.Week;
import challenge.backend.util.CustomRandom;

@Service
public class TransactionService {

   @Autowired
   TransactionDao transactionDaoI;

   /**
    * 
    * @param transaction input object
    * @return transaction output object with new transaction id
    */
   public Transaction AddTransaction(Transaction transaction) {

      DecimalFormat decimalFormat = new DecimalFormat("#.00");
      transaction.setAmount(Double.parseDouble(decimalFormat.format(transaction.getAmount()))); 
      transaction = transactionDaoI.save(transaction);// saving model

      return transaction;

   }

   public Transaction showTransaction(int transactionId, int userId)throws Exception {
      Transaction transactionDto = transactionDaoI.findById(transactionId).get();// getting model from optional
      if (transactionDto.getUserId() != userId)
         throw new Exception("Transaction not found");
   
      return transactionDto;

   }

   private List<Transaction> orderByDate(List<Transaction> transactions) {

      Collections.sort(transactions, new Comparator<Transaction>() {
         @Override
         public int compare(Transaction o1, Transaction o2) {
            return o1.getDate().compareTo(o2.getDate());
         }

      });
      return transactions;
   }

   /**
    * 
    * @param userId numeric unteger id from user
    * @return list of transactions
    */
   public List<Transaction> listTransactions(int userId)throws Exception {
      List<Transaction> transactions = transactionDaoI.findByUserId(userId);
      if(transactions.size()==0){
         throw new Exception("user doesnt exist or havent transactions");
      }

      return orderByDate(transactions);

   }

   public TransactionSum sumTransaction(int userId)throws Exception {

      List<Transaction> transactions = transactionDaoI.findByUserId(userId);
      if(transactions.size()==0){
         throw new Exception("the user doesnt exist");
      }
      double sum=transactions.stream().reduce(0.0, ( sub,actual)->sub+actual.getAmount(),Double::sum);
      DecimalFormat numberFormat = new DecimalFormat("#.00");
   
      sum=Double.parseDouble(numberFormat.format(sum));
      return new TransactionSum(sum,userId);


   }

   public List<Week> transactionReportService(int userId) {
      List<Transaction> transactions = transactionDaoI.findByUserId(userId);// get user from DB
      transactions = orderByDate(transactions);// order the list
      Week week = new Week();
      List<Week> weeks = new ArrayList<Week>();
      double auxAcumulator = 0;
      Transaction tran;
      int weekIndex=-1;
      for (int i = 0; i < transactions.size(); i++) {
         tran = transactions.get(i);

         if (week.getWeekStart() == null) {// if the week its new
            week.setWeekStart(tran.getDate());
            week.setWeekEnd(tran.getDate());
            week.setAmount(tran.getAmount());
            week.setQuantity(1);
            week.setTotalAmount(auxAcumulator);
            week.setUserId(userId);
            weeks.add(week);//adds the new week into the array
            weekIndex++; //increases pointer for the array

         } else {
            week=weeks.get(weekIndex); //gets the newest week and modifys
            week.setAmount(week.getAmount() + tran.getAmount());
            week.setQuantity(week.getQuantity() + 1);

            
         }
         if (i + 1 < transactions.size()  && !week.beelongThisWeek(transactions.get(i + 1).getDate())) {//if the next transaction date its not in this week creates a new one
            auxAcumulator += week.getAmount();
            week = new Week();
         }
      }
      return weeks;
   }

   public Transaction randomSingleTransaction(){
      List<Transaction>  list=transactionDaoI.findAllList();
      double random=CustomRandom.generate();
      int index=Math.abs((int)Math.round(random*(list.size())-1));
      return list.get( index);



   }
}
