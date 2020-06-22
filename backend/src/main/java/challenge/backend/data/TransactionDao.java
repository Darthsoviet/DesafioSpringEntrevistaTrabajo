package challenge.backend.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import challenge.backend.models.Transaction;

public interface TransactionDao extends CrudRepository<Transaction, Integer> {

   /**
    * 
    * @param userId integer userId
    * @return list of users From DB
    */

   @Query("select t from Transaction t where t.userId= :userId")
   public List<Transaction> findByUserId(@Param("userId") int userId);

   @Query("select t from Transaction t")
   public List<Transaction> findAllList();

}