//******************************************************************************************
// MRMReadStrings.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************

import java.util.Scanner;

public class MRMReadStrings
{
   //-----------------------------------------------------------------
   //  Creates an exception object and throws it as appropriate.
   //-----------------------------------------------------------------
   public static void main (String[] args) throws MRMStringTooLongException
   {
      final int MAX = 20;
      String input = "";

      Scanner scan = new Scanner (System.in);

      MRMStringTooLongException lengthException =
         new MRMStringTooLongException ("String has too many characters");

      System.out.println("Enter strings, enter DONE when finished:");

	  do
      {
         input = scan.nextLine();
         if (!input.equals("DONE"))
         try{
             if(input.length() > MAX)
               throw lengthException;
             else
               System.out.println ("You entered: " + input);
         }
         catch(MRMStringTooLongException e){
             System.out.println("String has too many characters");
         }
    
                 }
      while (!input.equals("DONE"));

      System.out.println("Program successfully completed");
   }
}
