//******************************************************************************************
// MRMLaptop2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************

public class MRMLaptop2 extends MRMComputer2 {
   public void setWiFiStatus(String wifiStatus) {
      wifiQuality = wifiStatus;
   }

   @Override
   public void printStatus() {
      super.printStatus();
      System.out.println("WiFi: " + wifiQuality);
   }

   private String wifiQuality;
}
