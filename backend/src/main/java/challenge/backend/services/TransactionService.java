package challenge.backend.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge.backend.data.TransactionDao;
import challenge.backend.models.Transaction;

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

      transaction = transactionDaoI.save(transaction);// saving model

      return transaction;

   }

   public Transaction showTransaction(int transactionId, int userId) {
      Transaction transactionDto = transactionDaoI.findById(transactionId).get();// getting model from optional
      if (transactionDto.getUserId() != userId)
         return null;

      return transactionDto;

   }

   /**
    * 
    * @param userId numeric unteger id from user
    * @return list of transactions
    */
   public List<Transaction> listTransactions(int userId) {
      List<Transaction> transactions = transactionDaoI.findByUserId(userId);
      return null;
      
   }

}