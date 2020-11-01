import java.util.Scanner;
public class Product_Assignment {
	
	public static void main(String[] args) {
		//Input instance is defined, then user is prompted
		Scanner sc = new Scanner(System.in);	
		System.out.print("Enter An Integer: ");
		int in = sc.nextInt();
		sc.close();
		System.out.println("");
		
		//Conditional which runs the calculation of the input if the inputted integer is >= 0
		if(in <= 0)
			System.out.println("Invalid Input");
		else
			System.out.println("The Product of the Numbers up to " + in + " are: " + Product(in));
	}
	
	//Calculates the product of the number inputed and returns that value as an int
	public static int Product(int x) {
		//Placeholder for the product
		int prod = 1;
		
		//Calculates the product of the number with a for loop going from 1 to x
		for(int count = 1; count <= x;count++)
			prod *= count;		
		
		return prod;
	}
}
