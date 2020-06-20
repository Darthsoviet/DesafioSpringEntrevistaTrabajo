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
   @PostMapping(path = "api/v1/transactions/user/{user_id}")

   public ResponseEntity<Transaction> addTransaction(@PathVariable(name = "user_id", required = true) int userId,
         @RequestBody(required = true) Transaction transaction) {

      transaction = transactionService.AddTransaction(transaction);

      return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
   }

   // ---------------------------------------------GET--------------------------------

   @GetMapping(path = "api/v1/transactions/transaction/{transaction_id}/{user_id}")
   public ResponseEntity<Object> showTransaction(@PathVariable(name = "transaction_id",required = true)
   int transactionId,@PathVariable(name="user_id" ,required = true)int userId){

      Transaction transaction=transactionService.showTransaction(transactionId, userId);
      if(transaction==null)
         return ResponseEntity.badRequest().body("Transaction not found");

      return ResponseEntity.ok(transaction);
      
   }



   @GetMapping(path = "api/v1/transactions/{id_transaction}")

   public ResponseEntity<List<Transaction>> listTransactions(
         @PathVariable(name = "id_transaction", required = true) int userId) {

      List<Transaction> transactions = transactionService.listTransactions(userId);

      return ResponseEntity.ok(transactions);
   }

}
