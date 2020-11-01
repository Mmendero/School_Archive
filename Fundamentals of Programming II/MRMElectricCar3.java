//******************************************************************************************
// MRMElectricCar3.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMElectricCar3 extends MRMCar3{
   public void setBatteryLevel(int levelToSet) {
      batteryLevel = levelToSet;
   }

   public void printBatteryLevel() {
      System.out.print("Battery: " + batteryLevel);
   }

   private int batteryLevel;
}