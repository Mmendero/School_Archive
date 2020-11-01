//******************************************************************************************
// MRMDerivedItem.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMDerivedItem extends MRMBaseItem {
   private String firstName;

   public void setFirstName(String providedName) {
      firstName = providedName;
   }

   @Override
   public void printItem() {
      System.out.print("First and last name: ");
      System.out.println(firstName + " " + lastName);
   }
}