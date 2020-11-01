//******************************************************************************************
// MRMSumofExcess.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMSumofExcess {
   public static void main (String [] args) {
      final int NUM_VALS = 4;
      int[] testGrades = new int[NUM_VALS];
      int i;
      int sumExtra = -9999; // Assign sumExtra with 0 before your for loop

      testGrades[0] = 101;
      testGrades[1] = 83;
      testGrades[2] = 107;
      testGrades[3] = 90;

      sumExtra = 0;
      for(i = 0; i < testGrades.length; i++){
         if(testGrades[i] > 100)
            sumExtra += testGrades[i] % 100;
      }

      System.out.println("sumExtra: " + sumExtra);
   }
}