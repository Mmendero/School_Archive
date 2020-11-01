//******************************************************************************************
// MRMDog4.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMDog4 {
   private int years;
   private int weight;
   private String size;
   private int humanYears;

   private void setHumanYears() {
      int factor;
   
      if (size == "small") {
         factor = 6;
      }
      else if (size == "medium") {
         factor = 7;
      }
      else {
         factor = 8;
      }
   
      humanYears = years * factor;
   }
   
   public int getHumanYears() {
      return humanYears;
   }

   public void SetWeightAndAge(int weightToSet, int yearsToSet) {
      weight = weightToSet;

      if (weight <= 25) {
         size = "small";
      }
      else if (weight <= 45) {
         size = "medium";
      }
      else {
         size = "large";
      }

      years = yearsToSet;
      setHumanYears();
   }
}