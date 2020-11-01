//******************************************************************************************
// MRMCallPerson1.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMCallPerson1 {

	public static void main(String[] args) {
		String userName;
	    MRMPerson1 person1 = new MRMPerson1();
	   
	    userName = "Max";

	    person1.setFirstName(userName);
	    System.out.print("You are " + person1.getFirstName());

	}

}
