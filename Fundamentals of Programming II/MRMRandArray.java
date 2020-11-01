//******************************************************************************************
// MRMRandArray.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMRandArray {

	public static void main(String[] args) {
		final int LIMIT = 10;
		int[] arr = new int[LIMIT];
		
		for(int i = 0; i < LIMIT; i++) {
			arr[i] = (int)(Math.random() * (100 - 1) + 1);
		}
		
		for(int num : arr){
			System.out.println(num);
		}

	}

}
