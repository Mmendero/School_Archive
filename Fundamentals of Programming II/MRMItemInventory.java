//******************************************************************************************
// MRMItemInventory.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.ArrayList;

public class MRMItemInventory {
   public static void main (String [] args) {
      MRMBaseItem baseItemPtr;
      MRMDerivedItem derivedItemPtr;
      ArrayList<MRMBaseItem> itemList = new ArrayList<MRMBaseItem>();
      int i;

      baseItemPtr = new MRMBaseItem();
      baseItemPtr.setLastName("Smith");

      derivedItemPtr = new MRMDerivedItem();
      derivedItemPtr.setLastName("Jones");
      derivedItemPtr.setFirstName("Bill");

      itemList.add(baseItemPtr);
      itemList.add(derivedItemPtr);

      for (i = 0; i < itemList.size(); ++i) {
         itemList.get(i).printItem();
      }
   }
}
