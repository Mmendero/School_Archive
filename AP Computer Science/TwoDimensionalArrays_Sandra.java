public class TwoDimensionalArrays_Sandra {
//Sandra Ibraham 3-B AP Computer Science
	public static void main(String[] args) {
		int SIZE= 5;
		int [][] A= new int[SIZE][SIZE];
		int LENGTH = A.length;
		load(A, LENGTH);
		print(A, LENGTH);
		sumandaverage(A,LENGTH);
		sumofrows(A,LENGTH);
		sumofcolumns(A,LENGTH);
		sumofdiagonals(A,LENGTH);
		sumoftopdiagonalhalf(A, LENGTH);
		
	}

	public static void load(int[][] A, int LENGTH)
	{
		int n=1;
		for(int r=0; r<LENGTH; r++)
			for(int c=0; c<A[0].length;c++)
				A[r][c] = (int)(Math.random()*n)+1;
	}
	
	public static void print(int[][]A, int LENGTH){
		for (int r=0; r<LENGTH;r++)
		{
			for (int c=0; c<A[0].length;c++)
			{
				System.out.printf("%3d",A[r][c]);
			}
			System.out.println();
		}	
		System.out.println();
	}
		
		public static void sumandaverage(int[][] A, int LENGTH)
		{
			int totalcells=0;
			int total=0;
			for(int r=0; r<LENGTH; r++)
				for(int c=0; c<A[0].length;c++)
				{
					total+= A[r][c];
					totalcells++;
				}
			double average=(double) total/totalcells;
			double averagerounded=Math.round(average*10)/10.0;
			System.out.println("a) Total value= "+total);
			System.out.println();
			System.out.println("b) Average= "+averagerounded);
			System.out.println();
			
		}
		
		public static void sumofrows(int[][] A, int LENGTH)
		{
			System.out.print("c) ");
			int sumofrows=0;
			for(int r=0; r<LENGTH; r++)
			{
				for(int c=0; c<A[0].length;c++)
				{
					sumofrows+= A[r][c];
				}
			System.out.println("Sum of row "+(r+1)+"= "+sumofrows);
			sumofrows=0;
			}
			System.out.println();
		}
	
		public static void sumofcolumns(int[][] A, int LENGTH)
		{
			System.out.print("d) ");
			int sumofcolumns=0;
			for(int c=0; c<LENGTH; c++)
			{
				for(int r=0; r<A[0].length;r++)
				{
					sumofcolumns+= A[r][c];
				}
			System.out.println("Sum of column "+(c+1)+"= "+sumofcolumns);
			sumofcolumns=0;
			}
			System.out.println();
		}
		
		public static void sumofdiagonals(int[][] A, int LENGTH)
		{
			int sumofdiagonals=0;
			
			for(int r=0; r<LENGTH; r++)
				sumofdiagonals+=A[r][r];
			
			int r=0;
				for(int c=LENGTH-1; c>=0; c--)
				{
					if(r!=c)
					sumofdiagonals+=A[r][c];
					r++;
				}
			System.out.println("e) Sum of the diagonals= "+sumofdiagonals);
			System.out.println();
			
		}
		
		public static void sumoftopdiagonalhalf(int[][] A, int LENGTH)
		{
		int sumoftopdiagonal = 0;
		for (int r=0; r<LENGTH;r++)
			{
			for (int c=LENGTH-1; c>r ;c--){
				sumoftopdiagonal += A[r][c];
			}
		}
		System.out.println("f) Sum of top diagonal half= "+sumoftopdiagonal);
	}


}
