//******************************************************************************************
// MRMBasicDerivedOverride.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************

public class MRMBasicDerivedOverride {
   public static void main (String [] args) {
      MRMPetData userPet = new MRMPetData();

      userPet.setName("Fluffy");
      userPet.setAge (5);
      userPet.setID  (4444);
      userPet.printAll();
      System.out.println("");
   }
}
