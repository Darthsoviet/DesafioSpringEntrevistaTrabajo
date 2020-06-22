package challenge.backend;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import challenge.backend.models.Week;

public class TestWeek {
   @Test

   public void testSearchClose() {
      Week week = new Week();
      LocalDate start = LocalDate.of(1998, 12, 31);
      System.out.println(start.getDayOfWeek());
      LocalDate res = week.serachCloseWeekDay(start);
      System.out.println(res + " " + res.getDayOfWeek());

      assertTrue(res.getDayOfWeek().equals(DayOfWeek.FRIDAY));

      LocalDate start2 = LocalDate.of(1999, 1, 1);
      System.out.println(start2.getDayOfWeek());
      LocalDate res2 = week.serachCloseWeekDay(start2);
      System.out.println(res2 + " " + res2.getDayOfWeek());

      assertTrue(res2.getDayOfWeek().equals(DayOfWeek.FRIDAY));

      LocalDate start3 = LocalDate.of(2020, 6, 2);
      System.out.println(start3.getDayOfWeek());
      LocalDate res3 = week.serachCloseWeekDay(start3);
      System.out.println(res3 + " " + res3.getDayOfWeek());

      assertFalse(res3.getDayOfWeek().equals(DayOfWeek.FRIDAY));
      assertTrue(start.getMonthValue() == res.getMonthValue());

   }

   @Test
   public void testSearchNext() {

      Week week = new Week();
      LocalDate start = LocalDate.of(1998, 12, 31);
      System.out.println(start.getDayOfWeek());
      LocalDate res = week.serachNextWeekDay(start);
      System.out.println(res + " " + res.getDayOfWeek());

      assertTrue(start.getMonthValue() == res.getMonthValue());

      LocalDate start2 = LocalDate.of(1999, 1, 1);
      System.out.println(start2.getDayOfWeek());
      LocalDate res2 = week.serachNextWeekDay(start2);
      System.out.println(res2 + " " + res2.getDayOfWeek());

      assertTrue(res2.getDayOfWeek().equals(DayOfWeek.THURSDAY));

      LocalDate start3 = LocalDate.of(2020, 6, 29);
      System.out.println(start3.getDayOfWeek());
      LocalDate res3 = week.serachNextWeekDay(start3);
      System.out.println(res3 + " " + res3.getDayOfWeek());

      assertFalse(res3.getDayOfWeek().equals(DayOfWeek.THURSDAY)); // shuld not bee thursday cause the month ends
      assertTrue(start.getMonthValue() == res.getMonthValue());

   }
}
