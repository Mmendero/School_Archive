//******************************************************************************************
// MRMAnimalPowered2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMAnimalPowered2 extends MRMVehicle2 {
   public void setAnimal(String animalToSet) {
      animal = animalToSet;
   }

   public void printAnimalSpeed() {
      System.out.print(animal + " speed: ");
      printSpeed();
   }

   private String animal;
}