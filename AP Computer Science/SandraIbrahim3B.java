import java.util.Scanner;
public class SandraIbrahim3B 
{
	private static final double LABORRATE= 25.75;
	private static final double CABLECOST= .65;
	private static final double SERVICECHARGE= 35.00;
	private static final double TAX= 1.06875;
	private static Scanner stdin = new Scanner(System.in);
	public static void main(String[] args) 
	{
		System.out.print("Date of service: ");
		String date= stdin.nextLine();
		
		System.out.print("Time of Service: ");
		String time= stdin.nextLine();
		
		System.out.print("Job Number: ");
		String jobnum= stdin.nextLine();
		
		System.out.print("Full Name: ");
		String name= stdin.nextLine();
		
		System.out.print("Address: ");
		String address= stdin.nextLine();
		
		System.out.print("Phone number: ");
		String phonenum= stdin.nextLine();
		
		double hours=Hoursworked();
		double rater= Hoursrate(hours);
		double cable= Cableused();
		double cablecalcround= Cableusedrate(cable);
		double subtotalr= Subtotal(cablecalcround, rater);
		double totalround=Total(subtotalr);
		double taxr=tax(subtotalr, totalround);
		Print(rater, cablecalcround, subtotalr, totalround, date, time, jobnum, 
				name, address, phonenum, hours, cable, taxr);
	}

	public static double Hoursworked()
	{
		System.out.println("Enter number of Hours worked: ");
		double hours= stdin.nextDouble();	
		return hours;
	}
	
	public static double Hoursrate(double hours)
	{
		double rate= LABORRATE*hours;
		double raterounded= Math.floor(rate*100)/100.0;
		return raterounded;
	}
	
	public static double Cableused()
	{
		System.out.println("Enter amount of cable used in feet: ");
		double cable= stdin.nextDouble();
		return cable;
		
	}
	
	public static double Cableusedrate(double cable)
	{
		double cablecalc= cable*CABLECOST;
		double cablecalcr= Math.floor(cablecalc*100)/100.0;
		return cablecalcr;
		
	}
	
	public static double Subtotal(double cablecalcround, double rater)
	{

		double subtotal= cablecalcround + rater + SERVICECHARGE;
		double subtotalrounded=  Math.floor(subtotal*100)/100.0;
		return subtotalrounded;
		
	}
	
	public static double Total(double subtotalr)
	{

		double total= subtotalr*TAX;
		double totalr= Math.floor(total*100)/100.0;		
		return totalr;
	}
	
	public static double tax(double subtotalr, double totalround)
	{
		double taxr=totalround-subtotalr;
		return taxr;
		
	}
	
	public static void Print(double rater, double cablecalcround, double subtotalr, 
			double totalround, String date, String time, String jobnum, 
			String name, String address, String phonenum, double hours, double cable, double taxr)
	{
		System.out.printf("%47s%n","Sandra's Service Supply");
		System.out.println("");
		System.out.printf("%70s%n","Date of Service: "+date);
		System.out.printf("%70s%n","Time of Service: "+time);
		System.out.printf("%70s%n","Job Number: "+jobnum);
		System.out.println("**********************************************************************");
		System.out.printf("%45s%n","Clients Information:");
		System.out.println("");
		System.out.println(name);
		System.out.println(address);
		System.out.println(phonenum);
		System.out.println("**********************************************************************");
		System.out.printf("%40s %n","Job Detail:");
		System.out.println("");
		System.out.printf("%s %24.2f %s %n", "Hours Worked: ", hours, "hours");
		System.out.printf("%s %16.2f %s %n", "Amount of Cable used: ", cable, "feet");		
		System.out.println("**********************************************************************");
		System.out.printf("%43s%n","Job Description:");
		System.out.println("");
		System.out.printf("%s %31s %28s %n","Service:","Price:","Amount Owed:");
		System.out.println("");
		System.out.printf("%s %18s %.2f %21s %6.2f %n","Service Charge:","$ ",SERVICECHARGE, 
						"$", SERVICECHARGE);
		System.out.printf("%s %22s %.2f %s %11s %6.2f %n","Labor Rate:","$ ",LABORRATE," per/hour", 
							"$", rater);
		System.out.printf("%s %22s %5.2f %s %11s %6.2f %n","Cable Cost:","$ ",CABLECOST," per/foot", 
							"$",cablecalcround);
		System.out.println("**********************************************************************");
		System.out.printf("%58s %3s %6.2f %n","Subtotal","$",subtotalr);
		System.out.printf("%58s %3s %6.2f %n","Tax","$",taxr);
		System.out.printf("%58s %3s %6.2f %n","Total","$",totalround);
		
		
		
	}
	
}