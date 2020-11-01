//******************************************************************************************
// MRM2DPoem.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRM2DPoem {

	public static void main(String[] args) {
		final int SIZE = 4;
		String[] poem = new String[SIZE];
		
		poem[0] = "Roses are red";
		poem[1] = "Violets are blue";
		poem[2] = "I've never found someone as patient";
		poem[3] = "As you";
	
		poem[SIZE - 1] = "but I have commitment issues";
		
		for(String sentence : poem) {
			System.out.println(sentence);
		}

	}

}
