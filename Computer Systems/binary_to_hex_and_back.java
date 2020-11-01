import java.util.Scanner;

public class binary_to_hex_and_back {
	
	private static String binary_to_hex(int input) {
		
		//Binary to Decimal function from problem 1
		int decimal = 0;
		int remaining = input;
		int factor = 0;
		
		while(remaining != 0) {
			
			if(remaining % 10 == 1) {
				decimal += Math.pow(2, factor);
			}
			
			factor++;
			remaining /= 10;
			
		}
		
		//Decimal to Hex
		String hex = "";
		factor = 0;
		
		//iterate through the number by decrementing the decimal number by 16
		while(decimal != 0) {
			int num;
			
			//Check which hex value represents the current decimal number % 16
			switch(decimal % 16) {
			case 15:
				hex = "F" + hex;
				break;
			case 14:
				hex = "E" + hex;
				break;
			case 13:
				hex = "D" + hex;
				break;
			case 12:
				hex = "C" + hex;
				break;
			case 11:
				hex = "B" + hex;
				break;
			case 10:
				hex = "A" + hex;
				break;
			default:
				num = decimal % 16;
				hex = Integer.toString(num) + hex;
			}
			
			decimal = decimal / 16;	
		}
		return hex;
	}
	
	private static int hex_to_bin(String input) {
		
		//hex to decimal
		int deci = 0;
		int factor = 0;
		
		for(int i = input.length(); i > 0; i--) {
			//check each hex number and add its value to its total decimal equivalent
			switch(input.substring(i-1,i)) {
			case "F":
				deci += 15 * Math.pow(16, factor);
				break;
			case "E":
				deci += 14 * Math.pow(16, factor);
				break;
			case "D":
				deci += 13 * Math.pow(16, factor);
				break;
			case "C":
				deci += 12 * Math.pow(16, factor);
				break;
			case "B":
				deci += 11 * Math.pow(16, factor);
				break;
			case "A":
				deci += 10 * Math.pow(16, factor);
				break;
			default:
				deci += Integer.parseInt(input.substring(i-1,i)) * Math.pow(16, factor);
			}
			//increment the factor to raise 16 to
			factor++;
		}
		
		//Decimal to Binary function from problem #2
		int binary = 0;
		int remaining = deci;
		factor = 1;
		
		while(remaining / 2 != 0) {
			
			binary += (remaining % 2)*factor;
			factor *= 10;
			remaining /= 2;
			
		}
		
		binary += (remaining % 2)*factor;
		
		return binary;
	}	
	
	//Input Prompt
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a Number in Binary: ");
		int input = scn.nextInt();
		scn.close();
		
		String hex = binary_to_hex(input);
		System.out.println("Hexadecimal: ");
		System.out.println(hex);
		
		int bin = hex_to_bin(hex);
		System.out.println("Hexadecimal converted back to Binary: ");
		System.out.print(bin);

	}



	
}
