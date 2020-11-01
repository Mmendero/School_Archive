//******************************************************************************************
// MRMSumofNRecursion.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;
public class MRMSumofNRecursion {	
	public static void main(String[] args) {	
		Scanner scn = new Scanner(System.in);
		int num;		
	    System.out.print("Enter a Number: ");
	    num = scn.nextInt();	    
	    System.out.println("Sum = " +addNumbers(num));
	}	
	public static int addNumbers(int n)
	{
	    if(n != 0)
	        return n + addNumbers(n-1);
	    else
	        return n;
	}
}
