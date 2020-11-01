//******************************************************************************************
// MRMStringInputStream3.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.StringWriter;

public class MRMStringInputStream3 {
   public static void main(String[] args) {
      String item;
      int quantity;
      int discount;

      StringWriter itemCharStream = new StringWriter();
      PrintWriter itemOSS = new PrintWriter(itemCharStream);

      item = "Headphones";
      quantity = 14;
      discount = 35;

      itemOSS.println(item + " x" + quantity);
      itemOSS.print(discount + "% off");

      System.out.print(itemCharStream.toString());
   }
}