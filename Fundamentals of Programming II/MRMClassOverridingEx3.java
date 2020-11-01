//******************************************************************************************
// MRMClassOverridingEx3.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************

public class MRMClassOverridingEx3 {
   public static void main(String[] args) {
      MRMLaptop3 myLaptop = new MRMLaptop3();

      myLaptop.setComputerStatus("15%", "connected", "good");

      myLaptop.printStatus();

   }
}