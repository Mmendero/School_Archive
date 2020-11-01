//******************************************************************************************
// MRMStringInputStream1.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMStringInputStream1 {
   public static void main(String[] args) {
      Scanner itemISS = null;
      String itemInfo;
      String item;
      int quantity;
      int price;

      itemInfo = "Shoes 14 17";
      itemISS = new Scanner(itemInfo);

      item = itemISS.next();
      quantity = itemISS.nextInt();
      price = itemISS.nextInt();

      System.out.println(item + " x" + quantity);
      System.out.print("Price: " + price);
   }
}