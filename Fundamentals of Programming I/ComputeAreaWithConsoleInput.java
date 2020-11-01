//Matthew Mendero
import java.util.Scanner;
public class ComputeAreaWithConsoleInput {

	public static void main(String[] args) {
		Scanner input =   new Scanner(System.in);
		System.out.print ("Enter Number for Radius: ");
		double radius = input.nextDouble();
		input.close();
		double area = radius * radius * 3.14159;
		System.out.println ("Area of the circle of radius, " +radius + ", is: " + area);
		
	}

}
