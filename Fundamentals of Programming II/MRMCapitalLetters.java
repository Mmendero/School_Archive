//******************************************************************************************
// MRMCapitalLetters.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMCapitalLetters {

	public static void main(String[] args) {
		final int LIMIT = 26;
		char[] arr = new char[LIMIT];
		
		char letter = 'A';
		
		for(int i = 0; i < LIMIT; i++) {
			arr[i] = letter;
			letter++;
		}
		
		for(int i = 0; i < LIMIT; i += 2){
			System.out.println(arr[i]);
		}

	}

}
