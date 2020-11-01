import java.util.Scanner;
public final class IfElseCompare {
	private static Scanner stdin = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("A: ");
		int a = stdin.nextInt();
		System.out.print("B: ");
		int b = stdin.nextInt();
		System.out.print("C: ");
		int c = stdin.nextInt();
		Print1(a,b,c);
		
	}
	private static void Print1(int a, int b, int c) {
		if (a > b)
			if (a > c)
				{System.out.print("A is Biggest");}
			else 
				if (b > c)
					{System.out.print("B is Biggest");}
				else
					{System.out.print("C is Biggest");}
		
	}

}
