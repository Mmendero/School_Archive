//******************************************************************************************
// MRMCallPerson3.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMCallPerson3 {
	   public static void main(String [] args) {
		      String userName;
		      String differentUserName;
		      MRMPerson3 person1 = new MRMPerson3();

		      userName = "Joe";
		      differentUserName = "Max";
		   
		      person1.setFirstName(userName);
		      System.out.println("I am not " + person1.getFirstName());
		      person1.setFirstName(differentUserName);
		      System.out.println("I am " + person1.getFirstName());
		 }
}
