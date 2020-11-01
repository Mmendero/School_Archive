//******************************************************************************************
// MRM2DDiagonal.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRM2DDiagonal {
	
	public static void main(String[] args) {
		int ROW = 3;
		int COL = 3;
		String[][] array =  new String[ROW][COL];
		
		array[0][0] = "a";
		array[0][1] = "b";
		array[0][2] = "c";
		array[1][0] = "d";
		array[1][1] = "e";
		array[1][2] = "f";
		array[2][0] = "g";
		array[2][1] = "h";
		array[2][2] = "i";
		
		for(int r = 0;r < ROW; r ++) {
			System.out.print(array[r][r]+" ");
		}
		System.out.println("");
		
		for(int r = 0;r < ROW; r ++) {
			System.out.print(array[r][(COL - 1) - r]+" ");
		}
		
	}

}
