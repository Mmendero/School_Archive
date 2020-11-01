//******************************************************************************************
// MRMStudentDerivationFromPerson.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMStudentDerivationFromPerson {
   public static void main (String [] args) {
      MRMStudentData courseStudent = new MRMStudentData();

      courseStudent.setID(9999);
      courseStudent.setAge(20);
      courseStudent.setName("Smith");
      
      courseStudent.printAll();
      System.out.println(", ID: " + courseStudent.getID());

   }
}