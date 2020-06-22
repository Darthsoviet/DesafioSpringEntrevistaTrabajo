package challenge.backend.models;

import lombok.Data;

@Data
public class TransactionSum{
private int userId;
private double sum;

public TransactionSum(){

}
public TransactionSum(double sum,int userId){
   this.sum=sum;
   this.userId=userId;
}
   
}