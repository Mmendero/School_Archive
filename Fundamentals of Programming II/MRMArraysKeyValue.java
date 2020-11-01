//******************************************************************************************
// MRMArraysKeyValue.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMArraysKeyValue {
   public static void main (String [] args) {

      final int SIZE_LIST = 4;
      int[] keysList = new int[SIZE_LIST];
      int[] itemsList = new int[SIZE_LIST];
      int i;

      keysList[0] = 13;
      keysList[1] = 47;
      keysList[2] = 71;
      keysList[3] = 59;

      itemsList[0] = 12;
      itemsList[1] = 36;
      itemsList[2] = 72;
      itemsList[3] = 54;

      for(i = 0;i<SIZE_LIST;i++){
         if(keysList[i] < 60)
            System.out.print(itemsList[i] + " ");
      }

      System.out.println("");
   }
}

