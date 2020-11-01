//******************************************************************************************
// MRMComputer2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************

public class MRMComputer2 {
   public void setComputerStatus(String cpuStatus, String internetStatus) {
      cpuUsage = cpuStatus;
      internet = internetStatus;
   }

   public void printStatus() {
      System.out.println("CPU: " + cpuUsage);
      System.out.println("Internet: " + internet);
   }
   
   protected String cpuUsage;
   protected String internet;
}
