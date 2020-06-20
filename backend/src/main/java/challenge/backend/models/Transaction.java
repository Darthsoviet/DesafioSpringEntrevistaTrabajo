package challenge.backend.models;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


import lombok.Data;

@Data
@Entity
@NamedQueries({

   //Find a list of users by userId
   @NamedQuery(name = "findByUserId",query = "select t from Transaction t where t.userId=:userId")
})

//Model transaction
public class Transaction implements Serializable {
   private static final long serialVersionUID=1L;


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "transaction_id")
   private int transactionId;

   private double amount;

   private String description;

   private LocalDate date;

   @Column(name="user_id")
   private int userId;

   
}