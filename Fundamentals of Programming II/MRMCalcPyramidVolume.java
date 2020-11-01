//******************************************************************************************
//MRMZ_6.2.3.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMCalcPyramidVolume {
   
   public static double pyramidVolume(double bl, double bw, double ph){
      return bl * bw * ph * 1/3;
   }

   public static void main (String [] args) {
      System.out.println("Volume for 1.0, 1.0, 1.0 is: " + pyramidVolume(1.0, 1.0, 1.0));
   }
}