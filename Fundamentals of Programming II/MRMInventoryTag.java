//******************************************************************************************
// MRMInventoryTag.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMInventoryTag {
   private int quantityRemaining;

   public MRMInventoryTag() {
      quantityRemaining = 0;
   }

   public int getQuantityRemaining() {
      return quantityRemaining;
   }

   public void addInventory(int numItems) {
      if (numItems > 10) {
         quantityRemaining = quantityRemaining + numItems;
      }
   }
}