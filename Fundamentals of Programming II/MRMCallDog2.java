//******************************************************************************************
// MRMCallDog2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMCallDog2 {
   public static void main(String [] args) {
      MRMDog2 buddy = new MRMDog2();
      
      buddy.setAge(3);
      buddy.addBirthday();
      buddy.addBirthday();
      buddy.addBirthday();

      System.out.print(buddy.getAge());
   
   }
}