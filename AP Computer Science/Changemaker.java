import java.util.*;
public class Changemaker {
private static Scanner stdin = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println ("Enter Amount of $$");
		double Chnge = stdin.nextDouble();
		Chnge *= 100; 
		
		int Quarter = (int) Chnge/25;
		System.out.println (Quarter+" Quarters");
		Chnge -= Quarter*25;
		
		int Dime = (int) Chnge/10;
		System.out.println (Dime+" Dimes");
		Chnge -= Dime*10;
				
		int Nickel = (int) Chnge/5;
		System.out.println (Nickel+" Nickels");
		Chnge -= Nickel*5;
		
		int Penny = (int) Chnge/1;
		System.out.println (Penny+" Pennies");
		
	}

}
