import java.util.*;
public class SavingsBilling {
private static Scanner stdin = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Percent();
		RoundTenth();
		RugPrice();
		*/Savings();
	}
	
	public static void Percent() {
		System.out.println ("***Percent Method***");
		System.out.println ("");
		System.out.println ("Enter 1st Integer Value: ");
		double x = stdin.nextDouble();
		System.out.println ("Enter 2nd Integer Value: ");
		double y = stdin.nextDouble();	
		double P = x/y;
		P *= 100;
		
		System.out.println ("");
		System.out.println ((int)x+" is "+(int)P+"% of "+(int)y);
		System.out.println ("");
	} 
	
	public static void RoundTenth() {
		System.out.println ("***RoundTenth Method***");
		double rnd = (Math.random() * 16.000)-5.000;
		double Rnd1 = Math.round(rnd*1000)/1000.0;
		double Rnd2 = Math.round(rnd*10)/10.00;
		System.out.println ("");
		System.out.println ("Random Number: "+Rnd1);
		System.out.println ("Rounded Value: "+Rnd2);
		System.out.println ("");
	}
	
	public static void RugPrice() {
		System.out.println ("***Rug Price Method***");
		System.out.println ("");
		System.out.println ("Enter the Price of Rug. Ex: '153.99'");
		double rug = stdin.nextDouble();
		System.out.println ("Enter the Length of the Rug: ");
		double rugl = stdin.nextDouble();
		System.out.println ("Enter the Width of the Rug: ");
		double rugw = stdin.nextDouble();
		double ppsf = rug/(rugl*rugw);
		double Ppsf = Math.round(ppsf*1000)/1000.0;
		System.out.println ("");
		System.out.println ("Cost: $"+rug+"ft.  Length: "+rugl+"ft.  Width: "+rugw);
		System.out.println ("Price/Sq ft: $"+Ppsf);
		System.out.println ("");
	}
	
	public static void Savings() {
		System.out.println ("***Savings Method***");
		System.out.println ("");
		System.out.println ("Enter a Savings Balance: ");
		double bal = stdin.nextDouble();
		System.out.println ("Enter Interest Rate: ");
		double rate = stdin.nextDouble();
		System.out.println ("Enter Number of Years Invested: ");
		int year = stdin.nextInt();
		
		double A = bal*Math.pow((1+((rate/100)/4)),4*year);
		double RA = Math.round(A*100)/100.00;
		double interest = RA - bal;
		System.out.println ("Start Balance: $"+bal+"  # of Years: "+year+"  Rate: "+rate+"%");
		System.out.println ("End Balance:   $"+RA);
		System.out.println ("Interest:      $"+interest);
		
	}
	
	
	
	
	
}
