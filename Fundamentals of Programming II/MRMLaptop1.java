//******************************************************************************************
// MRMLaptop1.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMLaptop1 extends MRMComputer1 {
   public void setWiFiStatus(String wifiStatus) {
      wifiQuality = wifiStatus;
   }

   @Override
   public void printStatus() {
      System.out.println("CPU: " + cpuUsage);
      System.out.println("WiFi: " + wifiQuality);
   }

   private String wifiQuality;
}