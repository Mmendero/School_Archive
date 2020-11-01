//******************************************************************************************
//MRMZ_6.4.1.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMPopcornTimer {
   public static void printPopcornTime(int bagOunces) {

      if(bagOunces < 2){
         System.out.println("Too small");  
      }
      else if (bagOunces > 10){
          System.out.println("Too large");  
      }
      else
          System.out.println(6*bagOunces + " seconds"); 

   }

   public static void main (String [] args) {
      printPopcornTime(7);
   }
}