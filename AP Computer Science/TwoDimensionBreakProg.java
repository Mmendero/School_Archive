public final class TwoDimensionBreakProg {
	// Matthew Mendero 3-B AP Computer Science
	public static void main(String[] args) {
		int Row = 3;
		int Col = 3;
		int Start = 1;
		int End = 25;
		int[][] A = new int[Row][Col];
		int EDigit = DigitCount(End);
		LoadArray(A, Start, End);
		int TVal = TotalValue(A);
		double AVal = AverageValue(A, TVal);
		int D = DVal(A);
		int TopD = TopDiagonal(A);
		DataPrint(A, TVal, AVal, D, Row, Col, EDigit, TopD);

	}

	private static int DigitCount(int end) {
		int c = 0;
		do {
			end /= 10;
			c++;
		} while (end != 0);
		return c;
	}

	private static void LoadArray(int[][] a, int start, int end) {
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++)
				a[r][c] = (int) (Math.random() * (end - start + 1)) + start;
		}
	}

	private static int TotalValue(int[][] a) {
		int TSum = 0;
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++)
				TSum += a[r][c];
		}
		return TSum;
	}

	private static double AverageValue(int[][] a, int tval) {
		double aval = 0;
		int count = 0;
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++)
				count++;
		}
		aval = (double) tval / count;
		return aval;
	}

	private static int RowSum(int[][] a, int r) {
		int rSum = 0;
		r--;
		for (int x = 0; x < a[r].length; x++)
			rSum += a[r][x];
		return rSum;
	}

	private static int ColSum(int[][] a, int c) {
		int cSum = 0;
		c--;
		for (int x = 0; x < a.length; x++)
			cSum += a[x][c];
		return cSum;
	}

	private static int DVal(int[][] a) {
		int D = 0;
		int c = 0;
		for(int x = 0; x < a.length; x++) 
				D += a[x][x];	
		for(int y = a.length - 1;y >= 0; y--){
			if(c != y)
				D += a[c][y];
			c++;
		}
			
		return D;
	}
	
	private static int TopDiagonal(int[][] a) {
		int topd = 0;
		for(int x = 0; x <= a.length - 1; x++){
			for(int y = x+1; y <= a.length - 1; y++)
				topd += a[x][y];
		}
		return topd;
	}

	private static void DataPrint(int[][] a, int tVal, double aVal, int d, 
			int row, int col, int eDigit, int topd) {
		int RSum = 0;
		int CSum = 0;		
		int Format1 = 2 + eDigit;
		int Format2 = 2;
		int boxd = Format1 + Format2 + 1;

		System.out.print("-");
		for (int o = 0; o < col; o++) {
			for (int i = 0; i < boxd; i++)
				System.out.print("-");
		}
		System.out.println("");

		for (int r = 0; r < a.length; r++) {
			System.out.print("|");
			for (int c = 0; c < a[0].length; c++)
				System.out.printf("%" + Format1 + "d %" + Format2 + "s",
						a[r][c], "|");
			System.out.println("");
			if (r != (a.length - 1)) {
				System.out.print("|");
				for (int o = 0; o < col; o++) {
					for (int i = 0; i < boxd - 1; i++)
						System.out.print("-");
					System.out.print("|");
				}
				System.out.println("");
			}
		}
		System.out.print("-");
		for (int o = 0; o < col; o++) {
			for (int i = 0; i < boxd; i++)
				System.out.print("-");
		}
		System.out.println("");
// ArrayTable
		System.out.println("");
		System.out.println("Total Value = " + tVal);
		System.out.println("Average Value = " + aVal);
		System.out.println("");
		for (int rowcount = 1; rowcount <= row; rowcount++) {
			RSum = RowSum(a, rowcount);
			System.out.println("Sum of Row " + rowcount + " = " + RSum);
		}
		System.out.println("");
		for (int colcount = 1; colcount <= col; colcount++) {
			CSum = ColSum(a, colcount);
			System.out.println("Sum of Col " + colcount + " = " + CSum);
		}
		System.out.println("");
		System.out.println("Diagonal Sum = " + d);
		System.out.println("");
		System.out.println("Top Diagonal Sum = " + topd);

	}
	
}
