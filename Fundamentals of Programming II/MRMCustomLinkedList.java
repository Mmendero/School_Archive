//******************************************************************************************
// MRMCustomLinkedList.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Random;

public class MRMCustomLinkedList {
   public static void main (String [] args) {
      Random randGen = new Random();
      MRMIntNode headObj; // Create intNode objects
      MRMIntNode currObj;
      MRMIntNode lastObj;
      int i;      // Loop index
      int negativeCntr;

      negativeCntr = 0;
      headObj = new MRMIntNode(-1); // Front of nodes list
      lastObj = headObj;

      for (i = 0; i < 10; ++i) { // Append 10 rand nums
         int rand = randGen.nextInt(21) - 10;
         currObj = new MRMIntNode(rand);
         lastObj.insertAfter(currObj); // Append curr
         lastObj = currObj; // Curr is the new last item
      }

      currObj = headObj; // Print the list
      while (currObj != null) {
         System.out.print(currObj.getDataVal() + ", ");
         currObj = currObj.getNext();
      }
      System.out.println("");

      currObj = headObj; // Count number of negative numbers
      while (currObj != null) {

         if(currObj.getDataVal() < 0){
         negativeCntr++;  
         }

         currObj = currObj.getNext();
      }
      System.out.println("Number of negatives: " + negativeCntr);
   }
}