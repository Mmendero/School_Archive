//******************************************************************************************
//MRMZ_6.4.2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMShampooMethod {

   public static void printShampooInstructions(int numCycles){
      if(numCycles < 1)
         System.out.println("Too few.");
      else if (numCycles > 4)
         System.out.println("Too many.");
      else{
         for(int i = 1; i <= numCycles; i++){
            System.out.println(i+": Lather and rinse.");     
         }
         System.out.println("Done.");
      }
   }

   public static void main (String [] args) {
      printShampooInstructions(2);
   }
}