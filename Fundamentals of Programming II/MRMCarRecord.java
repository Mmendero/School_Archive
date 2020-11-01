//******************************************************************************************
// MRMCarRecord.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMCarRecord {
   private int yearMade;
   private int vehicleIdNum;

   public void setYearMade(int originalYear) {
      yearMade = originalYear;
   }

   public void setVehicleIdNum(int vehIdNum) {
      vehicleIdNum = vehIdNum;
   }

   public void print() {
      System.out.println("Year: " + yearMade + ", VIN: " + vehicleIdNum);
   }

   // FIXME: Write constructor, initialize year to 0, vehicle ID num to -1.

   public MRMCarRecord(){
      yearMade = 0;
      vehicleIdNum = -1;
   }

}