//******************************************************************************************
// MRMBaseItem.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMBaseItem {
   protected String lastName;

   public void setLastName(String providedName) {
      lastName = providedName;
   }

   // FIXME: Define printItem() method

   public void printItem(){
      System.out.println("Last name: "+lastName);  
   }

}