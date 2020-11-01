//******************************************************************************************
// MRMStudentData.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMStudentData extends MRMPersonData {
   private int idNum;

   public void setID(int studentId) {
      idNum = studentId;
   }

   public int getID() {
      return idNum;
   }
}