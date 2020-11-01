import java.util.Scanner;
public final class Looping {
	private static Scanner stdin = new Scanner(System.in);
	public static void main(String[] args) {
		//Matthew Mendero Class: 3-B
		/*ForLoop1();
		ForLoop2();
		ForLoop3();
		ForLoop4();
		ForLoop5();
		ForLoop6();
		ForLoop7();*/
		ForLoop8();
		ForLoop9();
		ForLoop10();
		
	}
	
	private static void ForLoop1() {
		System.out.println("1. Calculate 100000 - (1+2+3+4 ..., 100)");
		System.out.println("");
		int c;
		int x = 0;
		for (c = 1; c <= 100; c++){
			x += c;
		}
		int diff = 100000 - x;
		System.out.println("100000 - x = "+diff);
		System.out.println("");
		System.out.println("****************************************");
	}
		
	private static void ForLoop2() {
		System.out.println("2. Calculate (1 + 4 + 9 + 16 ..., 100)");
		System.out.println("");
		int sum = 0;
		int y = 1;
		for(int x = 1; x <= 100; x += y){
			System.out.println(x);
			sum += x;
			y += 2;
		}
		System.out.println("");
		System.out.println("Total Sum ="+sum);
		System.out.println("");
		System.out.println("****************************************");
	}
	
	private static void ForLoop3() {
		System.out.println("3. Calculate (1/2 + 1/3 + 1/4 ... 1/100)");
		System.out.println("");
		double sum = 0;
		for(double x = 2; x <= 100; x++){
			sum += 1/x;
		}
		System.out.println("Total Sum: "+sum);
		System.out.println("");
		System.out.println("****************************************");
	}
	
	private static void ForLoop4() {
		System.out.println("4. Calculate Factorial of Inputted Number "
				+ "(Please Enter a Number)");
		double x = stdin.nextDouble();
		double t = 1;
		for(double y = 1; y <= x; y++){
			t *= y;
		}
		System.out.println("Factorial: "+t);
		System.out.println("");
		System.out.println("****************************************");
		}

	private static void ForLoop5() {
		System.out.println("5. Calculate (1 * 8 * 27 * 64 * 125* ... 1000)");
		System.out.println("");
		int y = 1;
		for(int x = 1; x <= 10; x++){
			y *= Math.pow(x,3);
		}
		System.out.println("Product = "+y);
		System.out.println("");
		System.out.println("****************************************");
	}
	
	private static void ForLoop6() {
		System.out.println("6. Annual Manhattan Compound");
		System.out.println("");
		double price = 24;
		double percent = 1.06;
		double nprice = 0;
		int bought = 1626;
		int present = 2017;
		for(int x = bought; x < present; x++){
			price *= percent;
			nprice = Math.round(price*100)/100.0;
			System.out.println(nprice);
		}
		System.out.println("Price Today: $"+nprice);
		System.out.println("");
		System.out.println("****************************************");
	}
	
	private static void ForLoop7() {
		System.out.println("7. 3 Digits raised to 3rd Power");
		System.out.println("");
		System.out.println("Enter a 3 Digit Number");
		int Power = 3;
		for(int Num = 100; Num <= 999; Num++){
			int Dig3 = Num / 100;
			int Num2 = Num - (Dig3 * 100);
			int Dig2 = Num2 / 10;
			int Num3 = Num2 - (Dig2 * 10);
			int Dig1 = Num3;
			double p1 = Power(Dig1,Power);
			double p2 = Power(Dig2,Power);
			double p3 = Power(Dig3,Power);
			int ThreeSum = (int)(p1 + p2 + p3);
			if (ThreeSum == Num)
				System.out.println(ThreeSum);
		}
		System.out.println("");
		System.out.println("****************************************");
	}
	
	private static void ForLoop8() {
		System.out.println("8. Highest Power of 2");
		System.out.println("");
		System.out.println("Please Enter a Number");
		double x = stdin.nextDouble();
		double num = 2;
		double tpow = 0;
		double power = 0;
		for(power = 1; tpow <= x ;power ++){
			tpow = DPower(num,power);
		}
		power -= 2;
		System.out.println("Highest Power is: "+power);
		System.out.println("");
		System.out.println("****************************************");
	}

	private static void ForLoop9() {
		System.out.println("9. Positive to Binary");
		System.out.println("");
		System.out.println("Please Enter a Number");
		double num = stdin.nextDouble();
		double r = 0;
		int snum = 0;
		for(int c = 1;num == 1;c++){
			r = num % 2;
			if(r > 0)
				System.out.print("1");
			else 
				System.out.print("0");
			
			snum =  (int)((Math.floor(num+1) / 2));
			num -= snum;
		}	
		System.out.println("");
	}
	
	private static void ForLoop10() {
		System.out.println("10. Fibonacci Sequence");
		System.out.println("");
		int one = 1;
		int sum = 0;
		for (int two = 0; (one + two) < 1000; two = sum){
			sum = one + two;
			one = two;
			System.out.println(sum);		
		}
		
	}
	

	
	
	
	private static Double DPower(double x, double power) {
		double y = Math.pow(x, power);
		return y;
	}	
	
	private static Double Power(int x, int power) {
		double y = Math.pow(x, power);
		return y;
	}	
}
