//******************************************************************************************
// MRMAnimalData.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************

public class MRMAnimalData {
   private int ageYears;
   private String fullName;

   public void setName(String givenName) {
      fullName = givenName;
   }

   public void setAge(int numYears) {
      ageYears = numYears;
   }

   // Other parts omitted

   public void printAll() {
      System.out.print("Name: "  + fullName);
      System.out.print(", Age: " + ageYears);
   }
}