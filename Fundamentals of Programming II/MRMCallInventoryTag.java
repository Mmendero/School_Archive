//******************************************************************************************
// MRMCallInventoryTag.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMCallInventoryTag {
	public static void main (String [] args) {
	      MRMInventoryTag redSweater = new MRMInventoryTag();
	      int sweaterShipment;
	      int sweaterInventoryBefore;

	      sweaterInventoryBefore = redSweater.getQuantityRemaining();
	      sweaterShipment = 25;

	      System.out.println("Beginning tests.");

	      // FIXME add unit test for addInventory

	      redSweater.addInventory(sweaterShipment);
	      if(redSweater.getQuantityRemaining() != sweaterInventoryBefore + sweaterShipment)
	         System.out.println("   UNIT TEST FAILED: addInventory()");

	      System.out.println("Tests complete.");
	 }
}
