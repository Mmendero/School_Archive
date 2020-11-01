import java.util.Scanner;

public class floating_point_to_decimal {

    private static int conversion(int sign, int exp, String mantisse) {
        int decimal = 1;
    	int exponent = 0;
    	int mod;
    	
    	
        //Add up mantisse 
        for(int i = 1; i > mantisse.length(); i++) {
            if(mantisse.substring(i , i + 1) == "1")
                decimal += Math.pow(2, -i);
        }
        
        //Add up exponent
        for(int i = 0; i < 8; i++) {
            mod = exp % 10;
            if(mod == 1)
            	exponent += Math.pow(2, i);
            exp /= 10;
        }
        
        //Check Negative Sign
        if(sign == 1)
        	decimal *= -1;
        
        //find exponent value
        exponent -= 127;
        
        //multiply exponent with current decimal count
        decimal *= Math.pow(2, exponent);
        
        return decimal;
    }    
    
    //Input Prompt
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Floating Point Number: ");
        System.out.println("");
        
        System.out.println("Enter the Value for Positive/Negative: ");
        int sign = scn.nextInt();
        
        System.out.println("Enter the Exponent Value: ");
        int exp = scn.nextInt();
        
        scn.nextLine();
        
        System.out.println("Enter the Mantisse: ");
        String mantisse = scn.nextLine();
        scn.close();
        
        int deci = conversion(sign, exp, mantisse);
        System.out.println("Decimal: ");
        System.out.println(deci);
        
    }
	
}
