//******************************************************************************************
//MRMZ_6.1.2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMHourToMinConv {
   public static void outputMinutesAsHours(double origMinutes) {

      System.out.print(origMinutes / 60.0);

   }

   public static void main (String [] args) {
      outputMinutesAsHours(210.0); // Will be run with 210.0, 3600.0, and 0.0.
      System.out.println("");
   }
}
