//******************************************************************************************
// MRMDog2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMDog2 {
   private int years;
   
   public void setAge(int yearsToSet) {
      years = yearsToSet;
   }
   
   public void addBirthday() {
      years = years + 1;
   }
   
   public int getAge() {
      return years;
   }
}