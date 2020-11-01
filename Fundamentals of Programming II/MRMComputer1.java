//******************************************************************************************
// MRMComputer1.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMComputer1 {
   public void setComputerStatus(String cpuStatus, String internetStatus) {
      cpuUsage = cpuStatus;
      internet = internetStatus;
   }

   public void printStatus() {
      System.out.println("Internet: " + internet);
      System.out.println("CPU: " + cpuUsage);
   }
   
   protected String cpuUsage;
   protected String internet;
}
