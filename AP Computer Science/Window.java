public class Window {	
	private int[][] mymat;
	private int myrow;
	private int mycol;
	
	public Window(int row, int col){
		myrow = row;
		mycol = col;
		mymat = new int [row][col];
		WindowFill();
	}

	public boolean IsInbounds(int row, int col){
		if(row < 0 || row >= myrow)
			return false;
		if(col < 0 || col >= mycol)
			return false;
		return true;
	}
	
	public void ColorSquare(int ULrow, int ULcol, int n, int val){
		for(int r = ULrow;r < ULrow + n;r++){
			for(int c = ULcol;c < ULcol + n;c++){
				if(IsInbounds(r,c))	
					mymat[r][c] = val;
			}
		}
	}
	
	public int ValAt(int row, int col){	
		if(IsInbounds(row,col))
			return mymat[row][col];
		else 
			return -1;
	}
	
	public void PrintArray(){
		for(int row = 0;row < myrow;row++){
			for(int col = 0;col < mycol;col++){
				System.out.printf("%5s", mymat[row][col]);
			}
			System.out.println("");
		}
	}
	
	public void WindowFill(){
		for(int r = 0;r < myrow;r++){
			for(int c = 0;c < mycol;c++){
				mymat[r][c] = (int)(Math.random()*10)+1;
			}
		}
	}
	
	public int [] StorageArray(int ULRow, int ULCol, int nrows, int ncols){
		int [] sarray = new int [nrows * ncols];
		int x = 0;
		for(int r = ULRow; r < ULRow + nrows; r++){
			for(int c = ULCol; c < ULCol + ncols; c++){
				sarray[x] = ValAt(r,c);
				x++;
			}
		}
		return sarray;
	}
	
	public void Enlarge (int ULrow, int ULcol, int numrows, int numcols, int factor){;
		int [] Color = StorageArray(ULrow, ULcol, numrows, numcols);
		int x = 0;
		for(int r = ULrow; r < ULrow + (numrows * factor); r += factor){
			for(int c = ULcol; c < ULcol + (numcols * factor); c += factor){
				ColorSquare(r,c,factor,Color[x]);
				x++;
			}
		}
	}
	
	public int SumCross(int row, int col){
		int sum = 0;
		for(int c = 0; c < mymat[row].length; c++){
			sum += mymat[row][c];		
		}
		for(int r = 0; r < mymat.length; r++){
			if(r != row)
				sum += mymat[r][col];
		}	
		return sum;
	}
	
	public void RemoveCross(int row, int col){
		for(int c = 0; c < mymat[row].length; c++){
			mymat[row][c] = 0;
		}		
		for(int r = 0; r < mymat.length; r++){
			mymat[r][col] = 0;
		}	
	}
	
	public void DrawRectangle(int ULrow, int ULcol, int height, int width){
		int rmax = 0;
		int cmax = 0;
		
		if((ULrow + height) > mymat.length)
			rmax = mymat.length;
		else 
			rmax = ULrow + height + 1;
		
		if((ULcol + width) > mymat[0].length)
			cmax = mymat[0].length + 1;
		else 
			cmax = ULcol + width;
		
		
		for(int r = ULrow; r < rmax; r++)
			if(IsInbounds(r,ULcol))
				mymat[r][ULcol] = 0;
		
		for(int c = ULcol; c < cmax; c++)
			if(IsInbounds(ULrow,c))
				mymat[ULrow][c] = 0;
		
		for(int r = ULrow; r < rmax; r++)
			if(IsInbounds(r,ULcol + width))
				mymat[r][cmax - 1] = 0;
		
		for(int c = ULcol; c < cmax; c++)
			if(IsInbounds(ULrow,c))
				mymat[rmax - 1][c] = 0;
		
	}
	
	
	public static void main(String[] args) {
		Window test = new Window(10,15);		
//		PartOne(test);
//		PartTwo(test);
//		PartThree(test);
		PartFour(test);
	}
	
	

	

	private static void PartOne(Window test) {
		System.out.println("");
		System.out.println("PART I");
		test.PrintArray();
		System.out.println("");
		System.out.printf("%s %15s %n" , "IsInbounds(0,0)",test.IsInbounds(0,0));
		System.out.printf("%s %14s %n" , "IsInbounds(7,14)",test.IsInbounds(7,14));
		System.out.printf("%s %15s %n" , "IsInbounds(-2,5)",test.IsInbounds(-2,5));
		System.out.printf("%s %15s %n" , "IsInbounds(14,5)",test.IsInbounds(14,5));
		System.out.printf("%s %15s %n" , "IsInbounds(3,17)",test.IsInbounds(3,17));
		System.out.printf("%s %15s %n" , "IsInbounds(3,-1)",test.IsInbounds(3,-1));	
		System.out.println("");
		
		System.out.printf("%s %8s %n" , "ValAt(4,10)",test.ValAt(4,10));
		System.out.printf("%s %8s %n" , "ValAt(6,14)",test.ValAt(6,14));
		System.out.printf("%s %8s %n" , "ValAt(-1,6)",test.ValAt(-1,6));
		System.out.printf("%s %8s %n" , "ValAt(10,15)",test.ValAt(10,15));
		System.out.printf("%s %8s %n" , "ValAt(0,0)",test.ValAt(0,0));
		System.out.printf("%s %8s %n" , "ValAt(8,-2)",test.ValAt(8,-2));
		System.out.println("");
		
		System.out.println("test.ColorSquare(5,2,4,0)");
		test.ColorSquare(5,2,4,0);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.ColorSquare(0,12,6,0)");
		test.ColorSquare(0,12,6,0);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.ColorSquare(7,10,5,0)");
		test.ColorSquare(7,10,5,0);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.ColorSquare(2,6,5,0)");
		test.ColorSquare(2,6,5,0);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.ColorSquare(-2,0,8,0)");
		test.ColorSquare(-2,0,8,0);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.ColorSquare(6,-2,4,0)");
		test.ColorSquare(6,-2,4,0);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.ColorSquare(9,14,3,0)");
		test.ColorSquare(9,14,3,0);
		test.PrintArray();
		test.WindowFill();
		
	}
	
	private static void PartTwo(Window test) {
		System.out.println("");
		System.out.println("");
		System.out.println("PART II");
		System.out.println("");
		test.PrintArray();
		System.out.println("");
		
		System.out.println("test.Enlarge(2,1,2,4,3)");
		test.Enlarge(2,1,2,4,3);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		System.out.println("");
		test.PrintArray();
		
		System.out.println("test.Enlarge(6,0,3,2,3)");
		test.Enlarge(6,0,3,2,3);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		System.out.println("");
		test.PrintArray();
		
		System.out.println("test.Enlarge(1,4,1,4,3)");
		test.Enlarge(1,4,1,4,3);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		System.out.println("");
		test.PrintArray();
		
		System.out.println("test.Enlarge(5,5,3,3,4)");
		test.Enlarge(5,5,3,3,4);
		test.PrintArray();
		test.WindowFill();
		
	}
	
	private static void PartThree(Window test) {
		System.out.println("");
		System.out.println("");
		System.out.println("PART III");
		System.out.println("");
		test.WindowFill();
		test.PrintArray();
		System.out.println("");
		
		System.out.println("test.SumCross(1,3)");
		System.out.println(test.SumCross(1,3));
		test.SumCross(1,3);
		System.out.println("");
		
		System.out.println("test.SumCross(4,8)");
		System.out.println(test.SumCross(4,8));
		System.out.println("");
		
		System.out.println("test.SumCross(9,14)");
		System.out.println(test.SumCross(9,14));
		System.out.println("");
		
		System.out.println("test.RemoveCross(1,1)");
		test.RemoveCross(1,1);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.RemoveCross(1,3)");
		test.RemoveCross(1,3);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.RemoveCross(9,14)");
		test.RemoveCross(9,14);
		test.PrintArray();
		test.WindowFill();
		
		
		
	}
	
	private static void PartFour(Window test) {
		System.out.println("");
		System.out.println("");
		System.out.println("PART IV");
		System.out.println("");
		test.PrintArray();
		System.out.println("");
		
		System.out.println("test.DrawRectangle(1,2,5,4)");
		test.DrawRectangle(1,2,5,4);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.DrawRectangle(4,3,10,5)");
		test.DrawRectangle(4,3,10,5);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.DrawRectangle(4,4,8,9)");
		test.DrawRectangle(4,4,8,9);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.DrawRectangle(-2,3,5,8)");
		test.DrawRectangle(-2,3,5,8);
		test.PrintArray();
		test.WindowFill();
		System.out.println("");
		
		System.out.println("test.DrawRectangle(6,-1,4,14)");
		test.DrawRectangle(6,-1,4,14);
		test.PrintArray();
		test.WindowFill();
		
	}
		
	
}
	
	
	

