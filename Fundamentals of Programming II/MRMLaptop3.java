//******************************************************************************************
// MRMLaptop3.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************

public class MRMLaptop3 extends MRMComputer3 {
   public void setComputerStatus(String cpuStatus, String internetStatus,
                                 String wifiStatus) {
      cpuUsage = cpuStatus;
      internet = internetStatus;
      wifiQuality = wifiStatus;
   }

   @Override
   public void printStatus() {
      super.printStatus();
      System.out.println("WiFi: " + wifiQuality);
   }

   private String wifiQuality;
}
