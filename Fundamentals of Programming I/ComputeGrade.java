import java.util.Scanner;

public class ComputeGrade {
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("This Program Calculates and Prints Course Score and Grade for a Given Value");
		System.out.println("");
		double score = getScore();
		printGrade(score);
	}
	
	public static double getScore() {
		System.out.print("Please Insert a Course Value between 0 and 100: ");
		double score = console.nextDouble();
		System.out.println("");
		System.out.println("The Score is " + score + " out of 100");
		System.out.println("");
		return score;
		
	}
	
	public static void printGrade(double x) {	
		x /= 10;
		
		System.out.print("That Grade is ");
		
		if(x == 10) 
			System.out.println("a Perfect Score. Well done!");
		
		else if(x >= 9)
			System.out.println("Well Above Average. Excellent!");
		
		else if(x >= 8)
			System.out.println("Above Average. Nice job.");
		
		else if(x >= 7)
			System.out.println("Average.");
		
		else if(x >= 6) {
			System.out.println("Below Average.");
			System.out.println("You should see the Instructor to Clarify the Material Presented in Class.");
			}
		
		else
			System.out.println("not passing.");
		
	}
	
	
}
