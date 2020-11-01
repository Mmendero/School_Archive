import java.util.Scanner;
public class BillingProject {
	private static Scanner stdin = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter Name of Company: ");
		String Comp = stdin.nextLine();
		System.out.println("Enter Job Number (ex. ###-###-####): ");
		String Jn = stdin.nextLine();
		System.out.println("Enter The Date of Service: (ex. ##/##/##):");
		String Ds = stdin.nextLine();
		System.out.println("Enter The Time of Service: (ex. ##:##):");
		String Ts = stdin.nextLine();
		System.out.println("Enter Client's Name: ");
		String Nm = stdin.nextLine();
		System.out.println("Enter Client's Address: ");
		String Adrs = stdin.nextLine();
		System.out.println("Enter Client's Phone Number (ex. ###-###-####):");
		String Phn = stdin.nextLine();	
		final double CCOST = .65;
		final double NJTAX = 6.875;
		final double SVC = 35.00;
		final double LBRT = 25.75;
		double Hrs = HrsInput();
		double Cab = CableInput();
		double CabC = CabCalc(Hrs,Cab,CCOST);
		double Lcost = LaborCalc(Hrs,LBRT);
		double SubT = Subt(CabC,SVC,Lcost);
		double Tcost = TCalc(SubT,NJTAX);
		double Totcost = Totcost(SubT,Tcost);
		BillOut(Comp,Ds,Nm,Adrs,Phn,Jn);
		MathOut(NJTAX,SVC,LBRT,Hrs,Cab,CabC,Lcost,Tcost,CCOST,SubT,Totcost,Ts);
		}

		private static double HrsInput() {
			System.out.println("Enter Amount of Hours on Job: ");
			double Hrs = stdin.nextDouble();
			return Hrs;
			
		}
		
		private static double CableInput() {
			System.out.println("Enter Amount of Cable Used in Feet: ");
			double Cab = stdin.nextDouble();
			return Cab;	
			
		}
		
		private static double CabCalc(double Hrs, double Cab, double CCOST) {
			double Cabm = Cab*CCOST;
			double RCabm = Math.floor(Cabm *100)/100.0;
			return RCabm;
			
		}
		
		private static double LaborCalc(double hrs, double lBRT) {
			double lcost = lBRT * hrs;
			double Lcost = Math.floor(lcost *100)/100.0;
			return Lcost;
			
		}
		

		private static double Subt(double cabC, double sVC, double lcost) {
			double scost = (cabC+lcost+sVC);
		return scost;
		
		}
		
		private static double TCalc(double subt, double ntax) {
			double tcost = subt * (ntax / 100);
			double Tcost = Math.floor(tcost *100)/100.0; 		
			return Tcost;
			
		}
		
		private static double Totcost(double subT, double tcost) {
			double totcost = subT + tcost;
			return totcost;
		}
		
		private static void BillOut(String comp, String ds, String nm, String adrs,
				String phn, String jn) {			
			System.out.println("");
			System.out.println("-----------------------------------------------"
					+ "-----------------------");
			System.out.printf("%s %64s %n","|",ds);
			System.out.printf("%s %s %n","|",comp);
			System.out.printf("%s %s %n","|",jn);
			System.out.printf("%s %n","|");
			System.out.printf("%s %n","|");
			System.out.printf("%s %s %n","|",nm);
			System.out.printf("%s %s %n","|",adrs);
			System.out.printf("%s %s %n","|",phn);
			System.out.println("|----------------------------------------------"
					+ "----------------------|");			
			
		}
		
		private static void MathOut(double nJTAX, double sVC, double lBRT, double hrs,
				double cab, double cabC, double lcost, double tcost, double ccost, 
				double subT, double totcost, String ts) {
			System.out.printf("%s %20s %s %22s %s %5s %n","|","|","Description","|","Amount","|");
			System.out.println("|--------------------|-------------------------"
					+ "---------|------------|");
			System.out.printf("%s %s %4s %34s %10.2f %s %n", "|","Service Charge:","|","|",sVC,"|");
			System.out.printf("%s %s %8s %s %2s %21s %10.2f %s %n", "|","Labor Rate:","|",lBRT,
					"per/hr","|",lcost,"|");
			System.out.printf("%s %s %8s %5s %2s %21s %10.2f %s %n", "|","Cable Cost:","|",ccost,
					"per/ft","|",cabC,"|");
			System.out.println("|----------------------------------------------"
					+ "----------------------|");
			System.out.printf("%s %38s %29s %n","|","Job Overview","|");
			System.out.println("|----------------------------------------------"
					+ "----------------------|");	
			System.out.printf("%s %2s %15s %n", "|","Hrs Worked:",hrs);
			System.out.printf("%s %2s %9s %n", "|","Ft of Cable Used:",cab);
			System.out.printf("%s %2s %11s %n", "|","Time of Service:",ts);
			System.out.println("|----------------------------------------------"
					+ "----------------------|");		
			System.out.printf("%s %52s %2s %s %8.2f %s %n", "|","Subtotal","|","$",subT,"|");
			System.out.printf("%s %52s %2s %s %8.2f %s %n", "|","Tax Chrg","|","$",tcost,"|");
			System.out.printf("%s %52s %2s %s %8.2f %s %n", "|","Total","|","$",totcost,"|");
			System.out.print("-----------------------------------------------"
					+ "-----------------------");
		}
		
	}