import java.util.*;
public final class DaysInAMonth {
private static Scanner stdin = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the Month Number: (ex. '12')");
		int Month = stdin.nextInt();
		System.out.println("Enter the Year: (ex. '2000')");
		int Year = stdin.nextInt();
		MonthCheck(Month,Year); 
	}

	private static void MonthCheck(int month, int year) {
		switch(month){
		case 1: case 3: case 5: case 7:case 8:case 10:case 12: System.out.println("This Month had 31 Days");
		case 2: 
			if (year%4==0)
				System.out.println("February has 29 Days");
			else 
				System.out.println("February has 28 Days");			
			;break;
		case 4: case 6: case 9: case 11: System.out.println("This Month had 30 Days");
		default:System.out.println("Month Input Invalid");break; 
		}
	}
		
}			
