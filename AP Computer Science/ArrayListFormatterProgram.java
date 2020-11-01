import java.util.*;
public final class ArrayListFormatterProgram {
	public static void main(String[] args) {
		//Matthew Mendero AP Computer Science 3-B
		ArrayList <String> WordList = new ArrayList <String>();
		int FormattedLen = 20; 
		WordList.add("AP");
		WordList.add("COMP");
		WordList.add("SCI");
		WordList.add("ROCKS");
		int Wordnum = WordList.size();
		int Spacenum = Wordnum - 1;
		int TLetter = totalLetters(WordList, Wordnum);
		int GapW = basicGapWidth(WordList, FormattedLen, Spacenum, TLetter);	
		int LGap = leftoverSpaces(WordList, FormattedLen, Spacenum, TLetter);
		String FString = format(WordList, Spacenum, GapW, LGap);
		PrintFormatter(FormattedLen, Wordnum, TLetter, Spacenum, GapW, LGap,FString);
		
	}	
	
	private static int totalLetters(List <String> wordList, int wordnum ) {
		int Lcount = 0;
		String Word;
		for(int c = 0; c < wordnum; c++){
			Word = wordList.get(c);
			Lcount += Word.length();
		}
		return Lcount;
	}

	private static int basicGapWidth(ArrayList<String> wordList,
			int formattedLen, int spacenum, int tLetter) {
		int Space = formattedLen - tLetter;
		Space /= spacenum;
		return Space;
	}

	private static int leftoverSpaces(ArrayList<String> wordList,
			int formattedLen, int spacenum, int tLetters) {
		int lspace = formattedLen - tLetters;
		lspace %= spacenum;
		return lspace;
	}

	private static String format(ArrayList<String> wordList, int spacenum,
			int gapW, int lGap) {
		String FString = "";
		String GString = "";		
		FString += wordList.remove(0);
		for(int x = 0; x < spacenum; x++){
			for(int z = 0; z < gapW; z++)
				GString += " ";
			if(lGap > 0)
				GString += " ";
			FString += GString;
			FString += wordList.remove(0);
			lGap--;
			GString = "";
		}	
		return FString;
	}
	
	private static void PrintFormatter(int formattedLen, int wordnum,
			int tLetter, int spacenum, int gapW, int lGap,
			String fString) {
		System.out.println("String Length = " + formattedLen);
		System.out.println("Total Letter Count = " + tLetter);
		System.out.println("Total Number of Words = " + wordnum);
		System.out.println("Number of Gaps = " + spacenum);
		System.out.println("Basic Gap Width = " + gapW);
		System.out.println("Leftover Spaces = " + lGap);
		System.out.println("");
		System.out.println("Formatted Output:");
		System.out.println("");
		for(int b = 0; b < 5; b++)
			System.out.print(1234567890);
		System.out.println("");
		System.out.println(fString);
		
	}
}
