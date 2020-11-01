
//******************************************************************************************
// MRMStringInputStream2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;
public class MRMStringInputStream2 {
   public static void main(String[] args) {
      String item1Info = "Pen 7 4";
      String item2Info = "Notepad 11 12";
      String item3Info = "Book 25 22";

      Scanner itemISS = new Scanner(item1Info);
      String item;
      int quantity;
      int price;

      item = itemISS.next();
      price = itemISS.nextInt();
      quantity = itemISS.nextInt();

      System.out.println(item + " x" + quantity);
      System.out.print("Price: " + price);
   }
}