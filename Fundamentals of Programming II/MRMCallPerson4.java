//******************************************************************************************
// MRMCallPerson4.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMCallPerson4 {
	public static void main(String [] args) {
	      String aFirstName;
	      String anotherFirstName;
	      String aLastName;
	      String anotherLastName;

	      aFirstName = "Sue";
	      anotherFirstName = "Ron";
	      aLastName = "Stark";
	      anotherLastName = "Parker";

	      MRMPerson4 person1 = new MRMPerson4();
	      MRMPerson4 person2 = new MRMPerson4();
	      
	      person1.setFirstName(aFirstName);
	      person1.setLastName(aLastName);
	      person2.setFirstName(anotherFirstName);
	      person2.setLastName(anotherLastName);

	      System.out.println("You are " + person1.getFullName());
	      System.out.println("I am " + person2.getFullName());
	   }
}
