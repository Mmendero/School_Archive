//******************************************************************************************
// MRMCourseGradePrinter.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMCourseGradePrinter {
   public static void main (String [] args) {
      final int NUM_VALS = 4;
      int[] courseGrades = new int[NUM_VALS];
      int i;

      courseGrades[0] = 7;
      courseGrades[1] = 9;
      courseGrades[2] = 11;
      courseGrades[3] = 10;

      for (i = 0; i < courseGrades.length; ++i) {
      System.out.print(courseGrades[i] + " ");
      }
      System.out.println("");
      for (i = courseGrades.length - 1; i >= 0; --i) {
         System.out.print(courseGrades[i] + " ");
      }
      System.out.println("");


   }
}