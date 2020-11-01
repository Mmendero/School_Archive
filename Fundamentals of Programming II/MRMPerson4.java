//******************************************************************************************
// MRMPerson4.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMPerson4 {
	private String firstName;
	   private String lastName;

	   public void setFirstName(String firstNameToSet) {
	      firstName = firstNameToSet;
	   }
	   
	   public void setLastName(String lastNameToSet) {
	      lastName = lastNameToSet;
	   }
	   
	   public String getFullName() {
	      return firstName + " " + lastName;
	   }
}