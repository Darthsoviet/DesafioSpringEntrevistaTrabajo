package challenge.backend.models;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import lombok.Data;

@Data
public class Week {
   private String weekStart;
   private String weekEnd;
   private int quantity;
   private double amount;
   private double totalAmount;
   private int userId;

   
  
   public void setAmount(double amount){
      DecimalFormat df= new DecimalFormat("#.00");
      this.amount= Double.parseDouble( df.format(amount));

   }

   public void setTotalAmount(double totalAmount){
      DecimalFormat df= new DecimalFormat("#.00");
      this.totalAmount= Double.parseDouble( df.format(totalAmount));

   }
   public void setWeekStart(LocalDate date,DayOfWeek target) {
     date= this.serachCloseWeekDay( date);
      this.weekStart = date.toString() + " " + date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

   }
   public void setWeekStart(LocalDate date) {
        date= this.serachCloseWeekDay(date);
       this.weekStart = date.toString() + " " + date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
 
    }
   public void setWeekEnd(LocalDate date) {
      date= this.serachNextWeekDay(date);

      this.weekEnd = date.toString() + " " + date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

   }

   public LocalDate parseLocalDateWeekStart() {

      return LocalDate.parse(this.weekStart.split(" ")[0]);
   }

   public LocalDate parseLocalDateWeekEnd() {

      return LocalDate.parse(this.weekStart.split(" ")[0]);
   }


   public boolean beelongThisWeek(LocalDate date){
      if(serachCloseWeekDay(date).equals(this.parseLocalDateWeekStart()))
         return true;
      
         return false;
      
   }

   /**
    * searches from the closest friday to start the week , if the closest friday 
    * belongs to diferent month, then the weekstart its the 1st day of the month
    * @param date
    * @return
    */
   public LocalDate serachCloseWeekDay(LocalDate date){
      DayOfWeek target=DayOfWeek.FRIDAY;
      LocalDate copy;

      if(date.getDayOfWeek().equals(target)) return date;
      copy=date.minusDays(1);
      while(copy.getDayOfWeek().getValue()!=target.getValue() || copy.getMonthValue()!=date.getMonthValue()){

         if(copy.getMonthValue()!=date.getMonthValue()){//if its the previos month
            return copy.plusDays(1);

         }
         copy=copy.minusDays(1);
      }
      return copy;
   }


   /**
    * search for the closest next end of the week and evals,
    *if the next thursday its on next month, then the week ends on the month ends
    * @param date
    * @return
    */
   public LocalDate serachNextWeekDay(LocalDate date){
      DayOfWeek target=DayOfWeek.THURSDAY;
      LocalDate copy;

      if(date.getDayOfWeek().equals(target)) return date;
      copy=date.plusDays(1);
      while(copy.getDayOfWeek().getValue()!=target.getValue() || copy.getMonthValue()!=date.getMonthValue()){

         if(copy.getMonthValue()!=date.getMonthValue()){//if its the previos month
            return copy.minusDays(1);

         }
         copy=copy.plusDays(1);
      }
      return copy;
   }

   

   
   
}