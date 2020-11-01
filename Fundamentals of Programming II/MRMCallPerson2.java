//******************************************************************************************
// MRMCallPerson2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMCallPerson2 {

	public static void main(String[] args) {
	      String userFirstName;
	      String userLastName;
	      MRMPerson2 person1 = new MRMPerson2();
	   
	      userFirstName = "Ron";
	      userLastName = "Rogers";

	      person1.setFirstName(userFirstName);
	      person1.setLastName(userLastName);
	      System.out.print("I am " + person1.getFullName());
	}

}
