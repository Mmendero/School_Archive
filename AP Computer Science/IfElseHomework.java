
public final class IfElseHomework {

	public static void main(String[] args) {
		int Count = 20;
		double Speed = 123.46;
		A(Count,Speed);
		B(Count,Speed);
		C(Count,Speed);
		D(Count,Speed);
		
	}



	private static void A(int count, double speed) {
		if (count == 20)
		{
			if (speed < 100)
			{
				System.out.print ("A");
			}
			else
			{
				System.out.print ("B");
			}
		}
		else
		{
			if (speed < 100)
			{
				System.out.print ("C");
			}
			else
			{
				System.out.print ("D");
			}
		}
		
		}
		
	private static void B(int count, double speed) {
		if (speed < 200)
		{
			System.out.println("Slow");
		}
		else if (speed> 100)
		{
			System.out.println("Fast");
		}
	}	
	
	private static void C(int count, double speed) {
		if (count > 25)
		{
			if (speed < 100)
			{
				System.out.print ("A");
			}
			else
			{
				System.out.print ("B");
			}
		}
		else
		{
			if (speed < 100)
			{
				System.out.print ("C");
			}
			else
			{
				System.out.print ("D");
			}
		}
	}
	
	private static void D(int count, double speed) {
		if (speed < 100)
		{
			if (count < 20)
			{
				System.out.println(1);
			}
			else
			{
				System.out.println(2);
			}
		}
		else if (speed < 200)
		{ 
			if (count < 20)
			{
				System.out.println(3);
			}
			else
			{
				System.out.println(4);
			}
		}
		else 
		{
			if (count < 20)
			{
				System.out.println(5);
			}
			else
			{
				System.out.println(6);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
