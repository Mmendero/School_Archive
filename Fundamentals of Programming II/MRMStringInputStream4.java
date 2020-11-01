//******************************************************************************************
// MRMStringInputStream4.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMStringInputStream4 {
   public static void main (String [] args) {
      Scanner inSS = null;
      String userInput = "Jan 12 1992";
      inSS = new Scanner(userInput);

      String userMonth;
      int userDate;
      int userYear;

      userMonth = inSS.next();
      userDate = inSS.nextInt();
      userYear = inSS.nextInt();

      System.out.println("Month: " + userMonth);
      System.out.println("Date: " + userDate);
      System.out.println("Year: " + userYear);
   }
}