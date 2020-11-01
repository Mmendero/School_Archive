import java.util.*;
public final class MatthewMendero_NestedLoopingProgram {
	private static Scanner stdin = new Scanner(System.in);	
	public static void main(String[] args) {
	//Matthew Mendero Class:3-B
		Question1();
		Question2();
		Question3();
		Question4A();
		Question4B();
		Question4C();
		Question4D();
		Question5();
		Question6();
	}

	private static void Question1() {
		System.out.print("Question 1");
		System.out.println("");
		System.out.println("");
		int prod = 1;
		for(int c = 1;c <= 10;c++){
			for(int x = 1;x <= c;x++){
				prod *= x;
			}
			System.out.println(c+"! "+prod);
			prod = 1;
		}
		System.out.println("");
	}
	
	private static void Question2() {
		System.out.print("Question 2");
		System.out.println("");
		System.out.println("");
		int prod = 1;
		for(int x = 1; x <= 12; x++){
			for(int y = 1; y <= 12; y++){
				prod = x * y;
				System.out.printf("%4d %s",prod," ");
				prod = x;
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	private static void Question3() {
		System.out.print("Question 3");
		System.out.println("");
		System.out.println("");
		for(int x = 1;x <= 10;x++){
			System.out.print("Fa ");
			for(int y = 1;y <= 8;y++){
				System.out.print("La ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	private static void Question4A() {
		System.out.print("Question 4A");
		System.out.println("");
		System.out.println("");
		for(int x = 1;x <= 10;x++){
			for(int y = 10;y >= x;y--){
				System.out.print("*");
			}
			System.out.println("");
			for(int r = 1;r <= x;r++){
				System.out.print(" ");
			}
		}
		System.out.println("");
	}
	
	private static void Question4B() {
		System.out.print("Question 4B");
		System.out.println("");
		System.out.println("");
		for(int x = 9;x >= 0;x--){
			for(int y = 1;y <= x;y++){
				System.out.print(x);
			}
			System.out.println("");
		}
		System.out.println("");
	}

	private static void Question4C() {
		System.out.print("Question 4C");
		System.out.println("");
		System.out.println("");
		for(int x = 1;x <= 17;x+=2){
			for(int r = 17;r >= x;r--){
				System.out.print(" ");
			}
			for(int y = 1;y <= x;y++){
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	private static void Question4D() {
		System.out.print("Question 4D");
		System.out.println("");
		System.out.println("");
		for(int x = 1;x <= 3;x++){
			for(int y = 1;y <= 20;y++){
				System.out.print("*");
				switch(y){
				case 10:System.out.println(" ");break;
				case 20:System.out.println(" ");break;
				}
			}
			if (x<3){
				for(int y = 1;y <= 6;y++){
					System.out.print("*");
					switch(y){
					case 3:System.out.println(" ");break;
					case 6:System.out.println(" ");break;}
				}
			}
		}
		System.out.println("");
	}
		
	private static void Question5() {
		System.out.print("Question 5");
		System.out.println("");
		System.out.println("");
		for(int x = 1;x <= 6;x++){
			if(x < 2 || x > 5){
				for(int y = 0;y <= 50;y++){
					System.out.print("-");
				}
				System.out.println("");
			}
			else{
				for(int y = 0;y <= 50;y++){
					if((y % 10) == 0){
						System.out.print("|");
					}
					else 
					System.out.print("-");
				}
				System.out.println("");
			}
				
			if(x < 6){
				for(int c = 1;c <= 2;c++){
					for(int y = 1;y <= 6;y++){
						System.out.print("|");
						for(int r = 1;r <= 9;r++)
							System.out.print(" ");
						}
					System.out.println("");
					}
				}
			}
		System.out.println("");	
	}
	
	private static void Question6() {
		System.out.print("Question 6");
		System.out.println("");
		System.out.println("");
		double rave;
		double sum = 0;
		double average;
		double highest = 0;
		int x = 1;
		int c = 1;
		String highestn = "";
		
		
		System.out.println("Enter Student Name");
		String n = stdin.nextLine();
		do{
			for(c = 0;c <= 3;c++){
				System.out.println("Enter Grade #"+x);
				double g = stdin.nextDouble();
				if((g < 0) || (g > 100)){
					do{
						System.out.println(" ");
						System.out.println("Invalid Grade Input");
						System.out.println("Enter Grade #"+x);
						g = stdin.nextDouble();  }
					while((g < 0) || (g > 100));  }
				sum += g;
				x++;
			}
			average = sum/c;
			rave = Math.round(average * 100)/100.0;
			System.out.println(" ");
			System.out.printf("%s %s %1.2f",n,"has an average of",rave);
			System.out.println(" ");
			if(average > highest){
				highestn = n;
				highest = rave;}
			c = 0;
			x = 1;
			sum = 0;
			System.out.println(" ");
			System.out.println("Enter Student Name or 'done'");
			String Dummy = stdin.nextLine();
			n = stdin.nextLine();
		}
		while(!(n.equals("done")));
		System.out.println(" ");
		System.out.printf("%s %s %1.2f",highestn,"has the highest average of",highest);
	}
	






}
