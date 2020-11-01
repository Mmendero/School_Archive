import java.util.Scanner;

public class decimal_to_fpn {
	
	private static String decimalToFPN(float input)  
    {  
		//convert the typecasted float input to bits in the type int using library method
        int intput = Float.floatToIntBits(input);
        
        //convert integerbits to binary string
        String fpn_as_string = Integer.toBinaryString(intput);
        
        return fpn_as_string;
    }   
	
	//Input Prompt
    public static void main(String[] args) {
    	Scanner scn = new Scanner(System.in);
    	
        System.out.println("Enter a decimal number: ");
        int deci = scn.nextInt();
        
        //close scanner
        scn.close();
        
        String fpn = decimalToFPN(deci);
        
        //Conditional to make up for the off by one error caused by the conversion of int to binary string
        if(deci > 0)
        	System.out.println("Number in FPN binary: 0"+ fpn);
        else 
        	System.out.println("Number in FPN binary: 1"+ fpn);
    } 
}
