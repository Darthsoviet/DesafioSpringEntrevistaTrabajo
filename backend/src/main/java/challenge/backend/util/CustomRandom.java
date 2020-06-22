package challenge.backend.util;

public class CustomRandom {


   public static double generate(){
      Long rt=System.nanoTime();
      rt=rt%10000; //extract middle numbers
      rt=rt /100;
      Long rt2=System.nanoTime();
      rt2=rt2%10000;
      rt2=rt2 /100;
      double res=rt%(rt2+1);
     


      return res/100;
   }
   
}