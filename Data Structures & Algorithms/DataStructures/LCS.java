package DataStructures;

public class LCS {
	
	public static int lcs_length (String X, String Y) {
		/*
		 * fill in your code here
		 * Note: return the length of LCS, instead of c and b
		 */
		int xlen = X.length();
		int ylen = Y.length();
		
		int[][]direction = new int[xlen][ylen];
		int[][]order = new int[xlen + 1][ylen + 1];
		
		for(int i = 1; i <= xlen; i++)
			order[i][0] = 0;
		for(int j = 0; j <= ylen; j++)
			order[0][j] = 0;
		
		for(int i = 0; i < xlen; i++) {
			for(int j = 0; j < ylen; j++) {
				if(X.charAt(i) == Y.charAt(j)) {
					order[i + 1][j + 1] = order[i][j] + 1;
					direction[i][j] = 0;
				}
				else if(order[i][j + 1] >= order[i + 1][j]) {
					order[i + 1][j + 1] = order[i][j + 1];
					direction[i][j] = 1;
				}
				else {
					order[i + 1][j + 1] = order[i + 1][j];
					direction[i][j] = 2;
				}
			}
		}
		
		return order[xlen][ylen];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LCS.lcs_length("ABCBDAB", "BDCABA"));
		System.out.println(LCS.lcs_length("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA"));
	}

}
