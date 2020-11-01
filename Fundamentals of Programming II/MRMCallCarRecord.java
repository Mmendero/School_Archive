//******************************************************************************************
// MRMCallCarRecord.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMCallCarRecord {
   public static void main (String [] args) {
      MRMCarRecord familyCar = new MRMCarRecord();

      familyCar.print();
      familyCar.setYearMade(2009);
      familyCar.setVehicleIdNum(444555666);
      familyCar.print();

   }
}