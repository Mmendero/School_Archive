import java.util.*;
public final class PigLatinBois {
	private static Scanner stdin = new Scanner(System.in);
	public static void main(String[] args) {		
		boolean cont = true;
		do{
			System.out.println("Enter Input or Enter 'done'");
			String Input = stdin.nextLine();
			if(!(Input.equals("done")))
			{
				String NSent = PigLatinConvert(Input);
				System.out.println(NSent);
				System.out.println("");
			}
			else
			{
				cont = false;
			}
		}
		while(cont == true);
		System.out.println("");
		System.out.println("This Program Has Ended");
	}
		
	private static String PigLatinConvert(String sent) {
		String Nword = "";
		String NSent = "";
		String temp = "";
		int a = 0;
		int end = 0;	
		do
		{
			if(sent.indexOf(" ",a) >= 0)
				temp = sent.substring(a,sent.indexOf(" ",a));		
			else
			{
				end = 1;
				temp = sent.substring(a);
			}
			boolean vow = VowCheck(temp);
			if (vow == false)
			{	
				Nword += temp.substring(1) + temp.substring(0,1);	
			}
			else
				Nword += temp;	
			Nword += "ay";	
			
			NSent += Nword;			
			Nword = "";
			a += temp.length();
			
			if (a < sent.length() && sent.substring(a,a+1).equals(" "))
				NSent += " ";
			a++;
		}
		while(end == 0);	
		return NSent;	
	}

	private static Boolean VowCheck(String w) {

		boolean vow = false;
		String Vowels = ("AEIOUaeiou");
		String w1 = w.substring(0,1);
		
		for(int a = 0; a < Vowels.length();a++){
			String temp = Vowels.substring(a,a+1);
			if (w1.equals(temp)){
				vow = true;
				break;
				} 
			}		
		return vow;
	}
	
	
	
} 
