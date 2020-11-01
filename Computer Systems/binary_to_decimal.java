import java.util.Scanner;

public class binary_to_decimal {
	
	private static int binary_to_dec(int input) {
		int decimal = 0;
		int remaining = input;
		int power = 0;
		
		//add every digit by 2 to a certain power
		while(remaining != 0) {
			
			//if the mod of remaining is 1, then add 2^i 
			if(remaining % 10 == 1) {
				decimal += Math.pow(2, power);
			}
			
			//increment power
			power++;
			remaining /= 10;
			
		}
		
		return decimal;		
	}	
	
	//Input Prompt
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a Number in Binary: ");
		int input = scn.nextInt();
		scn.close();
		
		System.out.println("Decimal: ");
		System.out.print(binary_to_dec(input));

	}	

}
