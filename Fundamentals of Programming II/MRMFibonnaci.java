//******************************************************************************************
// MRMFibonacci.java   Author: Matthew Ryan Mendero Atis      Section: 02
//
// Represents the first n integers of the Fibonacci series and prints them

// then prints the nth number selected by the user
//*******************************************************************************************
import java.util.Scanner;
public class MRMFibonnaci {

	public static void main(String[] args) {
		final int LIMIT = 20;
		long[] series = new long[LIMIT];		
		
		int prev = 0;
		int cur = 1;
		int temp = 0;
		String suffix = "th";
		
		series[0] = prev;
		series[1] = cur;
		
		for(int i = 2; i < 20; i++) {
			temp = cur;
			cur += prev;
			series[i] = cur;
			prev = temp;
		}
		
		System.out.println("Fibonacci Sequence");
		
		for(int i = 0; i < LIMIT; i++) {
			if( i == LIMIT - 1)
				System.out.print(series[i]);
			else
				System.out.print(series[i]+", ");
		}
		
		System.out.println("");
		System.out.println("");
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the Number of the Series to be Displayed (Between 1 to 20 Inclusive)");
		int inp = scn.nextInt();
		
		while(inp < 1 || inp > 20) {
			System.out.println("Invalid Input!");
			System.out.println("Please Input a Number Between 1 and 20 Inclusive");
			inp = scn.nextInt();
		}
		
		if(inp == 1)
			suffix = "st";
		else if(inp == 2)
			suffix = "nd";
		else if(inp == 3)
			suffix = "rd";
		
			System.out.println("The "+inp+suffix+" Fibonacci Number is "+series[inp-1]+".");

	}

}
