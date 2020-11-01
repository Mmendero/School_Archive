//******************************************************************************************
// MRMVehicleDerivation3.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMVehicleDerivation3 {
   public static void main(String[] args) {
      MRMElectricCar3 myCar = new MRMElectricCar3();

      myCar.setSpeed(40);
      myCar.setBatteryLevel(10);

      myCar.printCarSpeed();
      System.out.println();
      myCar.printBatteryLevel();
   }
}