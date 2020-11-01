//******************************************************************************************
// MRMArrayListADT.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.ArrayList;

public class MRMArrayListADT {
   public static void printArrayList(ArrayList<Integer> numsList) {
      int i;

      for (i = 0; i < numsList.size(); ++i) {
         System.out.print(numsList.get(i));
         System.out.print(" ");
      }

      System.out.println("");
   }

   public static void main(String [] args) {
      ArrayList<Integer> numsList = new ArrayList<Integer>();

      numsList.add(101);
      numsList.add(200);
      numsList.add(103);

      numsList.remove(1);
      numsList.add(0,100);
      numsList.add(2,102);

      printArrayList(numsList);
   }
}