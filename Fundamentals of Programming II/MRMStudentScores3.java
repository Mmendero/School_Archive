//******************************************************************************************
// MRMStudentScores3.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMStudentScores3 {
   public static void main (String [] args) {
      final int SCORES_SIZE = 4;
      int[] bonusScores = new int[SCORES_SIZE];
      int i;

      bonusScores[0] = 10;
      bonusScores[1] = 20;
      bonusScores[2] = 30;
      bonusScores[3] = 40;

      for(i = 0; i < SCORES_SIZE - 1; i++)
         bonusScores[i] = bonusScores[i] + bonusScores[i+1];

      for (i = 0; i < bonusScores.length; ++i) {
         System.out.print(bonusScores[i] + " ");
      }
      System.out.println();
   }
}
