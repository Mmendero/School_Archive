//******************************************************************************************
// MRMDog1.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMDog1 {
   private int months;
   
   public void setAge(int monthsToSet) {
      months = monthsToSet;
   }
   
   public String getStage() {
      String stage;
      
      if (months < 10) {
         stage = "Puppy";
      }
      else if (months < 22) {
         stage = "Adolescence";
      }
      else if (months < 70) {
         stage = "Adulthood";
      }
      else {
         stage = "Senior";
      }
       
      return stage;
   }
}