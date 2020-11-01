//******************************************************************************************
// MRM30Fibonacci.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRM30Fibonacci {

	public static void main(String[] args) {
		final int LIMIT = 30;
		int[] arr = new int[LIMIT];
		
		
		int prev = 0;
		int cur = 1;
		int temp = 0;
		
		arr[0] = prev;
		arr[1] = cur;
		
		for(int i = 2; i < LIMIT; i++) {
			temp = cur;
			cur += prev;
			arr[i] = cur;
			prev = temp;
		}
		
		for(int num : arr){
			System.out.println(num);
		}

	}

}
