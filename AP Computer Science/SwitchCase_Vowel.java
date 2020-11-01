import java.util.*;
public final class SwitchCase_Vowel {
private static Scanner stdin = new Scanner(System.in);
		public static void main(String[] args) {
			System.out.println("Enter a Letter : ");
			String Letter = stdin.nextLine();
			LSelect(Letter);
	}
		private static void LSelect(String letter) {
			switch(letter){
			case "A":System.out.println(letter+" is a Vowel");break;
			case "a":System.out.println(letter+" is a Vowel");break;
			case "E":System.out.println(letter+" is a Vowel");break;
			case "e":System.out.println(letter+" is a Vowel");break;
			case "I":System.out.println(letter+" is a Vowel");break;
			case "i":System.out.println(letter+" is a Vowel");break;
			case "O":System.out.println(letter+" is a Vowel");break;
			case "o":System.out.println(letter+" is a Vowel");break;
			case "U":System.out.println(letter+" is a Vowel");break;
			case "u":System.out.println(letter+" is a Vowel");break;
			default:System.out.println(letter+" is not a Vowel");break;
			}			
		}
}