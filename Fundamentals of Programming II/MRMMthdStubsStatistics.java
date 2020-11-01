//******************************************************************************************
//MRMZ_6.3.2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import java.util.Scanner;

public class MRMMthdStubsStatistics {

   public static int getUserNum(){
      System.out.println("FIXME: Finish getUserNum()");
      return -1;
   }
   
   public static int computeAvg(int u1, int u2){
      System.out.println("FIXME: Finish computeAvg()");
      return -1;
   }

   public static void main(String [] args) {
      int userNum1;
      int userNum2;
      int avgResult;

      userNum1 = getUserNum();
      userNum2 = getUserNum();

      avgResult = computeAvg(userNum1, userNum2);

      System.out.println("Avg: " + avgResult);
   }
}