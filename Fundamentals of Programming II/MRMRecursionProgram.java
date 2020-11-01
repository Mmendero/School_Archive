//******************************************************************************************
// MRMRecursionProgram.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.*;
public class MRMRecursionProgram {
	
	public static int factorial(int in) {
		if(in != 1)
			return in * factorial(in-1);
		else			
			return in;
	}
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int input;
		
		System.out.print("Enter an Integer: ");
		input = scn.nextInt();
		System.out.println("");
		
		System.out.println(input+"!=  "+factorial(input));

	}
	
}
