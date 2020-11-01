//******************************************************************************************
// MRMArray10000.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMArray10000 {

	public static void main(String[] args) {
		final int LIMIT = 9999;
		int[] arr = new int[LIMIT];
		int count = 0;
	
		for(int i = 0; i < LIMIT; i++) {
			arr[i] = i+1;
		}
		
		for(int o = 0; o < 5; o++) {
			for(int i = 0; i < 5; i++) {
				System.out.print(arr[count]);
				if(i != 4)
					System.out.print(", ");
				count++;
			}
			System.out.println("");	
		}
	}

}
