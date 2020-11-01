//******************************************************************************************
// MRMPascalsTriangle.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMPascalsTriangle {
	
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the rows n: ");
    int rows = scn.nextInt();
    System.out.println("Pascal's Triangle:");
    print(rows);
  }

  public static void print(int n) {
	int spaces = n;
    for (int x = 0; x < n; x++) {
    	
      for (int i = 0; i < spaces; i++) {
    	  System.out.print(" ");
      }
      
      for (int y = 0; y <= x; y++) {
        System.out.print(pascal(x, y) + " ");
      }
      
      System.out.println();
      
      spaces--;
    }
  }

  public static int pascal(int f, int l) {
    if (l == 0 || l == f) {
      return 1;
    } else {
      return pascal(f - 1, l - 1) + pascal(f - 1, l);
    }
  }
}
