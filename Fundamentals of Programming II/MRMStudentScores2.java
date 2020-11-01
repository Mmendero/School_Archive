//******************************************************************************************
// MRMStudentScores2.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMStudentScores2 {
	   public static void main (String [] args) {
	      final int SCORES_SIZE = 4;
	      int[] oldScores = new int[SCORES_SIZE];
	      int[] newScores = new int[SCORES_SIZE];
	      int i;

	      oldScores[0] = 10;
	      oldScores[1] = 20;
	      oldScores[2] = 30;
	      oldScores[3] = 40;

	      int temp = oldScores[0];
	      for(i = 0 ; i < SCORES_SIZE-1; i ++){
	         newScores[i] = oldScores[i+1];
	      }
	      newScores[SCORES_SIZE - 1] = temp;

	      for (i = 0; i < newScores.length; ++i) {
	         System.out.print(newScores[i] + " ");
	      }
	      System.out.println();
	   }
	}