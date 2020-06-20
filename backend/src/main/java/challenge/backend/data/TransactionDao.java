package challenge.backend.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import challenge.backend.models.Transaction;

public interface TransactionDao extends CrudRepository<Transaction, Integer> {



   /**
    * 
    * @param userId integer userId
    * @return list of users From DB
    */
  public List<Transaction> findByUserId(int userId);

}