//******************************************************************************************
// MRMVehicleDerivation2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMVehicleDerivation2 {
   public static void main(String[] args) {
      MRMCar2 myCar = new MRMCar2();
      MRMAnimalPowered2 wagon = new MRMAnimalPowered2();

      myCar.setSpeed(40);
      wagon.setSpeed(6);
      wagon.setAnimal("Horse");

      myCar.printCarSpeed();
      System.out.println();
      wagon.printAnimalSpeed();
      
   }
}