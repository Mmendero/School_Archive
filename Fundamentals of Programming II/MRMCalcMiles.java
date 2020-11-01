//******************************************************************************************
//MRMZ_6.3.1.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMCalcMiles {

   public static double mphAndMinutesToMiles(double mph, double mt){
      return mt / 60 * mph;
   }

   public static void main(String [] args) {
      double milesPerHour = 70.0;
      double minutesTraveled = 100.0;

      System.out.println("Miles: " + mphAndMinutesToMiles(milesPerHour, minutesTraveled));
   }
}