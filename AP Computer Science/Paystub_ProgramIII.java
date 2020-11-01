import java.util.Scanner;
public final class Paystub_ProgramIII {
private static Scanner stdin = new Scanner(System.in);
	final static int OT = 40;
	final static int ROUNDCOL = 100;
	final static int UNIONP = 100;
	final static double UNIONDUE = 15;
	final static int TAXDEDUCT1 = 15;
	final static int TAXDEDUCT2 = 18;
	final static int TAXDEDUCT3 = 20;
	final static int TAXDEDUCT4 = 24;
	final static int TAXDEDUCT5 = 30;
	public static void main(String[] args) {
		System.out.println("Employee Name:");
		String Name = InputS();
		
		System.out.println("ID Number (Ex. '#########'):");
		String ID = InputS();
		
		System.out.println("Date (Ex. '##/##/##'):");
		String Date = InputS();
		
		System.out.println("Social Security (Ex. '###-##-####'): ");
		String SS = InputS();
		
		System.out.println("Job Title: ");
		String JTitle = InputS();
		
		System.out.println("Enter Hours Worked:");
		double Hour = InputDouble();
		
		System.out.println("Enter $$'s Earned Per Hour:");
		double Wage = InputDouble();
		
		double OHr = OHRCheck(Wage,Hour);
		double OTWage = OTWageCalc(Wage);
		double OPay = OPayCalc(OHr,OTWage);
		double RHour = Subtract(Hour,OHr);
		double RPay = RPayCalc(Wage,RHour);
		double TPay = TPayCalc(RPay,OPay);
		double UChrg = UnionCalc(TPay);
		double GPay = GrossCalc(RPay,OPay,UChrg);
		int TaxS = TaxStat(Wage);
		double TaxP = TaxCheck(TaxS);
		double TaxT = TaxCalc(GPay,TaxP);		
		double PayT = Subtract(GPay,TaxT);
		StubTop(Name,ID,Date,JTitle,SS);
		StubBot(Hour,Wage,OHr,OTWage,GPay,UChrg,
				TaxP,TaxT,PayT,Name,RHour,RPay,OPay);
	}
	private static String InputS() {
		String input = stdin.nextLine();
		return input;
	}	
	private static double InputDouble() {
		double input = stdin.nextDouble();		
		return input;
	}
	private static double Subtract(double x, double y){
		double out = x - y;
		return out;
	}
	private static double Rounding(double x){
		double out = Math.round(x * ROUNDCOL)/(ROUNDCOL+.0);
		return out;
	}		
	private static double OHRCheck(double wage, double hour){
		double othr = 0;
		if (hour > OT)
			othr = hour - OT;
		else 
			othr = 0;
		return othr;
	}	
	private static double OTWageCalc(double wage) {
		double rwage = Rounding(wage);
		double otwage = rwage / 2;
		double rotwage = Rounding(otwage);
		double Otwage = rotwage + rwage;
		return Otwage;
	}		
	private static double RPayCalc(double wage, double rHour) {
		wage *= rHour;
		double Rwage = Rounding(wage);
		return Rwage;
	}
	private static double OPayCalc(double oHr, double oTWage) {
		double Opay = 0;
		Opay = oHr * oTWage;
		double ROPay = Rounding(Opay);
		return ROPay;
	}	
	private static double TPayCalc(double Rpay, double Opay) {
		Rpay += Opay;		
		return Rpay;
	}	
	private static double UnionCalc(double pay) {
		double union = 0;
		if (pay > UNIONP)
			union = UNIONDUE;
		else
			union = 0;
		return union;
	}
	private static double GrossCalc(double rPay, double oPay, double uChrg) {
		rPay += oPay - uChrg;
		return rPay;
	}	
	private static int TaxStat(double wage) {
		int taxs = 0;
		if ((wage >= .01)&&(wage <= 6.00))
			taxs = 1;
		else if (wage <= 8.00)
			taxs = 2;
		else if (wage <= 12.00)
			taxs = 3;
		else 
			taxs = (wage <= 16.00)?(4):(5);	
		return taxs;
		
	}
	private static double TaxCheck(int taxS) {
		double tax = 0;
		switch (taxS){
		case 1:tax = TAXDEDUCT1;break;
		case 2:tax = TAXDEDUCT2;break;
		case 3:tax = TAXDEDUCT3;break;
		case 4:tax = TAXDEDUCT4;break;
		default:tax = TAXDEDUCT5;break;}
		return tax;
	}	
	private static double TaxCalc(double gpay, double taxP) {
		taxP /= ROUNDCOL;
		double tax = gpay * taxP;
		double rtax = Rounding(tax);
		return rtax;
	}
	private static void StubTop(String name, String iD, String date,
		String jTitle, String sS) {
		System.out.println("");
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%47s","Mendero Toothpick Factory");
		System.out.println("");
		System.out.println(name);
		System.out.println("Position: "+jTitle);
		System.out.println("**********************************************************************");
		System.out.printf("%15s %28s %20s %n", "Employee ID","Social Security","Pay Date");
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%15s %26s %24s %n", iD,sS,date);
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%10s %25s %23s %n", "Income","Hours","Rate");
		System.out.println("----------------------------------------------------------------------");
	
	}	
	private static void StubBot(double hour, double wage, double ohr,
		double otwage, double gpay, double uChrg, double taxP, double taxT,
		double payT, String name, double rHour, double rPay, double oPay) {
		System.out.printf("%10s %24.1f %18s %5.2f %5s %n", "Regular",rHour,"$",wage,"Per/Hr");
		System.out.printf("%11s %23.1f %18s %5.2f %5s %n", "Overtime",ohr,"$",otwage,"Per/Hr");
		System.out.println("");
		System.out.println("");
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%s %52.2f %n", "Total Hours:",hour);
		System.out.printf("%s %46s %6.2f %n", "Tax Status:","%",taxP);
		System.out.printf("%s %46s %6.2f %n", "Union Dues:","$",uChrg);
		System.out.printf("%s %44s %6.2f %n", "Overtime Pay:","$",oPay);
		System.out.printf("%s %45s %6.2f %n", "Regular Pay:","$",rPay);
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%13s %22s %28s %n", "Gross Pay","Taxes","Net Pay");
		System.out.printf("%5s %.2f %19s %.2f %20s %.2f %n", "$",gpay,"$",taxT,"$",payT);
		System.out.println("**********************************************************************");
		System.out.println("Mendero Toothpick Factory");
		System.out.println("");
		System.out.printf("%65s %n","Amount");
		System.out.printf("%58s %.2f %n","$",payT);
		System.out.println("Pay to: "+name);
		System.out.println("");
		System.out.printf("%65s %n","---------------");
		System.out.printf("%65s %n","M.Mendero");
		System.out.println("----------------------------------------------------------------------");
	}
	
	
}
