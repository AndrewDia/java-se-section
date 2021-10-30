package datetime.lesson6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;

public class QuestionExamples {
    public static void main(String[] args) {
        /* 1. Create a date of June 21, 2012 */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate june21 = LocalDate.of(2012, 6, 21);  // ok
        System.out.println(june21.format(formatter));
        june21 = LocalDate.of(2012, Month.JUNE, 21);          // ok
        System.out.println(june21.format(formatter));
        june21 = LocalDate.of(2012, 5, 21);            // incorrect: months begin from 1 in Month class, so May is chosen
        System.out.println(june21.format(formatter));
        // date = new LocalDate(2012, 6, 21);                                // incorrect: constructor has a private access
        june21 = LocalDate.of(2012, Calendar.JUNE, 21);       // incorrect: months begin from 0 in Calendar, so May is chosen
        System.out.println(june21.format(formatter));
        System.out.println();

        /* 2. What is the output? */
        LocalDate date = LocalDate.parse("2020-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
        date.plusDays(2);      // 1) result of this method is ignored because LocalDate is immutable
//        date.plusHours(3);   // 2) LocalDate does not keep time, so we cannot add hours (minutes, seconds)
        System.out.println(date);   // output is the same
        System.out.println();

        /* 3. What is the output? */
//        LocalDate incorrect = LocalDate.of(2020, Month.APRIL, 40);
//        System.out.println(incorrect);  // runtime exception, there is not 40 days in the month

        /* 4. What is the output? */
        LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p = Period.of(1, 2, 3);
        d = d.minus(p);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        // ofLocalizedTime means that only time will be formatted, but not date
        System.out.println(d.format(f));    // output: 11:22
        System.out.println();

        /* 5. What is the output? */
        LocalDateTime l = LocalDateTime.of(2017, 5, 10, 11, 22, 33);
        Period period = Period.ofDays(1).ofYears(2);  // only ofYears(2) method is counted
        l = l.minus(period);
        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(format.format(l));    // output: 10.05.15 11:22
    }
}
