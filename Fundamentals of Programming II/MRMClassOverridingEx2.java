//******************************************************************************************
// MRMClassOverridingEx2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************

public class MRMClassOverridingEx2 {
   public static void main(String[] args) {
      MRMLaptop2 myLaptop = new MRMLaptop2();

      myLaptop.setComputerStatus("15%", "connected");
      myLaptop.setWiFiStatus("good");

      myLaptop.printStatus();

   }
}