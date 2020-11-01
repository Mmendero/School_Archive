//******************************************************************************************
// MRMPetData.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMPetData extends MRMAnimalData {
   private int idNum;

   public void setID(int petID) {
      idNum = petID;
   }

   // FIXME: Add printAll() member function

   public void printAll(){
      super.printAll();
      System.out.print(", ID: " + idNum);
   }

}
