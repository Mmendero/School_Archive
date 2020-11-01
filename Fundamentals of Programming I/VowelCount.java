import java.util.Scanner;
public class VowelCount {

	public static void main(String[] args) {
		System.out.print("Enter a String: ");
		Scanner scn = new Scanner(System.in);
		String string = scn.nextLine();
		scn.close();
		int scount = 0;
		int counta = 0;
		int counte = 0;
		int counti = 0;
		int counto = 0;
		int countu = 0;

		for(int x = 0;x < string.length();x++) {
			
			switch(string.charAt(x)) {
			case 'a': 
				counta++;
				break;
			case 'e': 
				counte++;
				break;
			case 'i': 
				counti++;
				break;
			case 'o': 
				counto++;
				break;
			case 'u':
				countu++;
				break;
			default:
				scount++;
				break;
			}		
		}		
		System.out.println("");
		System.out.println("Number of Nonvowel Characters: " + scount);
		System.out.println("Number of a's: " + counta);
		System.out.println("Number of e's: " + counte);
		System.out.println("Number of i's: " + counti);
		System.out.println("Number of o's: " + counto);
		System.out.println("Number of u's: " + countu);
	}

}
