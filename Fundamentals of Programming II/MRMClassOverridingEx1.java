//******************************************************************************************
// MRMClassOverridingEx1.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************

public class MRMClassOverridingEx1 {
   public static void main(String[] args) {
      MRMLaptop1 myLaptop = new MRMLaptop1();

      myLaptop.setComputerStatus("25%", "connected");
      myLaptop.setWiFiStatus("good");

      myLaptop.printStatus();

   }
}