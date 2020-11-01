import java.util.*;

public class decimal_to_binary_conversion {	
	
	private static int dec_to_binary(int input) {
		int binary = 0;
		int remaining = input;
		int factor = 1;
		
		//continuously divide the decimal number by 10
		while(remaining / 2 != 0) {
			//depending on what place it is, add the binary number to the summation of the binary number
			binary += (remaining % 2)*factor;
			factor *= 10;
			remaining /= 2;
			
		}
		
		//check final digit of decimal number
		binary += (remaining % 2)*factor;
		
		return binary;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a Number in Decimal: ");
		int input = scn.nextInt();
		scn.close();
		
		System.out.println("Binary: ");
		System.out.print(dec_to_binary(input));

	}

}
