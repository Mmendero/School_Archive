//******************************************************************************************
//MRMZ_6.7.1.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMTemperatureConversion {
   public static double celsiusToKelvin(double valueCelsius) {
      double valueKelvin;

      valueKelvin = valueCelsius + 273.15;

      return valueKelvin;
   }

   public static double kelvinToCelsius(double valueKelvin){
      double valueCel;

      valueCel = valueKelvin - 273.15;

      return valueCel;
   }

   public static void main (String [] args) {
      double valueC;
      double valueK;

      valueC = 10.0;
      System.out.println(valueC + " C is " + celsiusToKelvin(valueC) + " K");

      valueK = 283.15;
      System.out.println(valueK + "  is " + kelvinToCelsius(valueK) + " C");
   }
}