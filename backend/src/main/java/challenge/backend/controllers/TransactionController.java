package challenge.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import challenge.backend.models.Transaction;
import challenge.backend.models.TransactionSum;
import challenge.backend.models.Week;
import challenge.backend.services.TransactionService;

@RestController

public class TransactionController {

   @Autowired
   TransactionService transactionService;

   // --------------------------------POST-------------------------------------------

   /**
    * 
    * @param userId      userId given on path param
    * @param transaction transaction from requets body
    * @return request transaction plus idTransaction
    */
   @PostMapping(path = "api/v1/transactions/user/{user_id}", consumes = "application/json")

   public ResponseEntity<Transaction> addTransaction(@PathVariable(name = "user_id", required = true) int userId,
         @RequestBody(required = true) Transaction transaction) {

      transaction = transactionService.AddTransaction(transaction);

      return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
   }

   // ---------------------------------------------GET--------------------------------

   @GetMapping(path = "api/v1/transactions/transaction/{transaction_id}/{user_id}")
   public ResponseEntity<Object> showTransaction(
         @PathVariable(name = "transaction_id", required = true) int transactionId,
         @PathVariable(name = "user_id", required = true) int userId) {

      Transaction transaction;
      try{
         transaction= transactionService.showTransaction(transactionId, userId);
      }catch(Exception ex){
       return  ResponseEntity.badRequest().body(ex.getMessage());
      }
   

      return ResponseEntity.ok(transaction);

   }

   @GetMapping(path = "api/v1/transactions/sum/{user_id}")
   public ResponseEntity<Object> sumTransactions(@PathVariable(name = "user_id") int userId) {
      TransactionSum sum;
      try {

         sum = transactionService.sumTransaction(userId);
      } catch (Exception ex) {
         return ResponseEntity.badRequest().body(ex.getMessage());
      }
      return ResponseEntity.ok(sum);

   }

   @GetMapping(path = "api/v1/transactions/{id_transaction}")

   public ResponseEntity<Object> listTransactions(
         @PathVariable(name = "id_transaction", required = true) int userId) {

      List<Transaction> transactions; 
      try{
         transactions= transactionService.listTransactions(userId);
      }catch(Exception ex){
         return ResponseEntity.badRequest().body(ex.getMessage());
      }
       

      return ResponseEntity.ok(transactions);
   }

   @GetMapping(path = "api/v1/transactions/week/{user_id}")
   public ResponseEntity<List<Week>> transactionReportService(
         @PathVariable(name = "user_id", required = true) int userId) {
      List<Week> weeks = transactionService.transactionReportService(userId);

      return ResponseEntity.ok(weeks);
   }

   @GetMapping(path = "api/v1/transactions/random")
   public ResponseEntity<Transaction> randomSingleTransaction() {
      Transaction tran = transactionService.randomSingleTransaction();
      return ResponseEntity.ok(tran);
   }
}
