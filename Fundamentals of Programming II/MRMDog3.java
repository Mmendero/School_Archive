//******************************************************************************************
// MRMDog3.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMDog3 {
   private int weight;
   private String size;
   
   public void setWeight(int weightToSet) {
      weight = weightToSet;
      
      if (weight <= 25) {
         size = "small";
      }
      else if (weight <= 55) {
         size = "medium";
      }
      else {
         size = "large";
      }
   }

   public String getSize() {
      return size;
   }
}