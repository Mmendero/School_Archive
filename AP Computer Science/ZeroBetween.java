public final class ZeroBetween {
	// Matthew Mendero 
	// 3-B AP Computer Science
	public static void main(String[] args) {
		int [] A = {10, 6, 2, 1, 9, 4};	
		int big = 0;		
		int Big1 = Big(A, big);
		int Big2 = Big(A, Big1);
		System.out.println("Old Array:");
		Print(A);
		ZeroInsert(A, Big1, Big2);
		System.out.println("New Array:");
		Print(A);
	}
	
	private static int Big(int [] a, int bigp) {
		int big;
		int c = 0;	
		if(bigp == 0)
			c = 1;		
		big = c;	
		for(int d = c;d < a.length; d++)
			if(a[d] > a[big] && a[d] != a[bigp])
				big = d;		
		return big;
	}
	
	private static void ZeroInsert(int [] a, int b1, int b2){
		int Big;
		int Small;		
		if(b1 > b2){
			Big = b1;
			Small = b2;
		}
		else{
			Big = b2;
			Small = b1;
		}		
		for(int pos = Small+1; pos < Big; pos++)
			a[pos] = 0;		
	}	
	private static void Print(int [] a) {
		for(int t: a)
			System.out.print(t + " ");
		System.out.println("");
		
	}	
}
