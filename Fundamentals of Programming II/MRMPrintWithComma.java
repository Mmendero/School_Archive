//******************************************************************************************
// MRMPrintWithComma.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMPrintWithComma {
   public static void main (String [] args) {
      final int NUM_VALS = 4;
      int[] hourlyTemp = new int[NUM_VALS];
      int i;

      hourlyTemp[0] = 90;
      hourlyTemp[1] = 92;
      hourlyTemp[2] = 94;
      hourlyTemp[3] = 95;

      for(i = 0; i < hourlyTemp.length; i++){
         if(i == hourlyTemp.length - 1)
            System.out.print(hourlyTemp[i]);
         else
            System.out.print(hourlyTemp[i] + ", ");
      }

      System.out.println("");
   }
}