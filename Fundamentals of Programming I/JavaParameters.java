import java.util.Scanner;
public class JavaParameters {
	
	public static void updateParameter(int[] x) {
		for (int i = 0; i < x.length; i++) {
			x[i] = 3333;
		}
	}
	
	public static void main(String[] args) {
		int a = 5;
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of the array that is to be created: ");
		System.out.println("");
		int size = scn.nextInt();
		int[] myArray = new int[size];
		
		System.out.println("Enter the elements of the array :");		
		for (int i = 0; i < size; i++) {
			myArray[i] = scn.nextInt();
		}
		
		System.out.println("");
		System.out.println ("Values of the array before calling updateArray: ");
		
		for(int x:myArray) {
			System.out.println(x);
		}
		
		updateParameter(myArray);
		
		System.out.println ("Result after calling updateParameter");
		
		for(int x:myArray) {
			System.out.println(x);
		}
	}

}

