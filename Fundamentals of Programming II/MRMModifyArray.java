//******************************************************************************************
//MRMZ_6.8.1.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMModifyArray {

  public static void swapArrayEnds(int[] arr,int numElem){
      int temp = arr[0];
      arr[0] = arr[numElem-1];
      arr[numElem-1] = temp;
   }

   public static void main (String [] args) {
      int numElem = 4;
      int[] sortArray = new int[numElem];
      int i;

      sortArray[0] = 10;
      sortArray[1] = 20;
      sortArray[2] = 30;
      sortArray[3] = 40;

      swapArrayEnds(sortArray, numElem);

      for (i = 0; i < numElem; ++i) {
         System.out.print(sortArray[i]);
         System.out.print(" ");
      }
      System.out.println("");
   }
}