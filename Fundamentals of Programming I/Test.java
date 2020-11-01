import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter Temperature: ");
		double t = scn.nextDouble();
		if(!(t < 20 || t > 40)) {
			System.out.println("Very cold");
		}

	}

}
