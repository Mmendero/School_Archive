//******************************************************************************************
// MRMArrayOutput.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMArrayOutput {
	public static void main (String [] args) {
	      final int NUM_ELEMENTS = 3;
	      int [] userVals = new int[NUM_ELEMENTS];
	      int i;
	   
	      userVals[0] = 1;
	      userVals[1] = 4;
	      userVals[2] = 7;
	   
	      for (i = 0; i < userVals.length; ++i) {
	         System.out.println(userVals[i]);
	      }
	   }
}
