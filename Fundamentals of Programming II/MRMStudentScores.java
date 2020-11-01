//******************************************************************************************
// MRMStudentScores.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMStudentScores {
   public static void main (String [] args) {
      final int SCORES_SIZE = 4;
      int[] lowerScores = new int[SCORES_SIZE];
      int i;

      lowerScores[0] = 5;
      lowerScores[1] = 0;
      lowerScores[2] = 2;
      lowerScores[3] = -3;

      for(i = 0; i < SCORES_SIZE; i++){
         if(lowerScores[i] > 0)
            lowerScores[i]--;
         else
            lowerScores[i] = 0;
      }

      for (i = 0; i < lowerScores.length; ++i) {
         System.out.print(lowerScores[i] + " ");
      }
      System.out.println();
   }
}