//******************************************************************************************
// MRMSevenDwarfs.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//
// Represents an ArrayList Demo
//******************************************************************************************

import java.util.ArrayList;
public class MRMSevenDwarfs {

	public static void main(String[] args) {
		ArrayList names = new ArrayList();
		names.add("Bashful");
		names.add("Doc");
		names.add("Dopey");
		names.add("Grumpy");
		names.add("Happy");
		names.add("Sleepy");
		names.add("Sneezy");
		display(names);
		
		
	}
		public static void display(ArrayList names)
		{
			System.out.println("The Size of the List is: " + names.size());
			System.out.println("");
			for(int x = 0; x < names.size();++x) 
				System.out.println("Position " + x + " Name: " + names.get(x));
			}

}


