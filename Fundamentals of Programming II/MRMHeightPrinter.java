//******************************************************************************************
//MRMZ_6.1.3.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMHeightPrinter {

   public static void printFeetInchShort(int ft, int ht){
      System.out.println(ft+"\' "+ht+"\"");
      return;
   }

   public static void main (String [] args) {
      printFeetInchShort(5, 8);  // Will be run with (5, 8), then (4, 11)
   }
}
