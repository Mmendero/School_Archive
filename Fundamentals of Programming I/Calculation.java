import java.util.Scanner;
public class Calculation {
	
	
	public static int sumSquare(int num) {
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i * i;
		}
		return sum;
	}
	
	public static double displacement(double x, double v, double t) {
		final double G = 9.78;
		return x + (v*t) - ((G*t*t)/2);
	}
	
	
	
	public static void main(String[] args) {
		int num;
		double x;
		double v;
		double t;
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("**************************");
		System.out.println("  Task 1: Sum of Squares");
		System.out.println("**************************");
		System.out.println("");
		
		System.out.print("Please Enter An Integer Larger Than 0: ");
		num = scn.nextInt();
		
		while(num < 1) {
			System.out.println("Invalid Input");
			System.out.print("Please Enter An Integer Larger Than 0: ");
			num = scn.nextInt();			
		}

		System.out.println("");
		System.out.println("The Sum of the Squares to "+num+": "+sumSquare(num));
		System.out.println("");
		
		System.out.println("**************************");
		System.out.println("   Task 2: Displacement");
		System.out.println("**************************");
		System.out.println("");
		
		System.out.println("Please Enter Three Double Values for x, v, and t (All Larger Than 0):");
		System.out.print("x: ");
		x = scn.nextDouble();

		System.out.print("v: ");
		v = scn.nextDouble();
			
		System.out.print("t: ");
		t = scn.nextDouble();
		
		System.out.println("");
		System.out.println("The Displacement With Values "+x+", "+v+", and "+t+": "+displacement(x,v,t));
		System.out.println("");
		scn.close();
				
	}

}
