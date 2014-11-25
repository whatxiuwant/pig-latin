package plpkg;

public class LetterCount {
	private String alpha = "abcdefghijklmnopqrstuvwxyz";
	private int[] alphaCount = new int[26];
	
	/*
	 * this.phrase = phrase;
	 * temp = phrase.toUpper
	 * for
	 * if (i >= 'A' && i <= 'Z')
	 * alphaCount[i - 'A']++;
	 * 
	 * outputToFile(File output) throws IOException
	 * .getName()
	 */
	
	public static void main(String[] args) {
		
	}
	
	public void count(String s) {
		for (int i = 0; i < s.length() - 1; i++)
			for (int j = 0; j < alpha.length() - 1; j++)
				if (s.substring(i, i + 1).equalsIgnoreCase(alpha.substring(i, i + 1)))
					alphaCount[j]++;
	}
}
