package plpkg;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class LetterCount {
	
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
	
	public static void main(String[] args) throws IOException {
		File input = new File("ioExample.txt");
		if (!input.exists()) {
			System.out.println("ioExample.txt does not exist.");
			System.exit(1);
		}
		
		Scanner scanner = new Scanner(input);
		//System.exit(0); means everything runs fine
		
		File output = new File("count.txt");
		if (output.exists()) {
			System.out.println("count.txt already exists.");
			System.exit(2);
		}
		 
		PrintWriter pw = new PrintWriter(output);
		String lineOfText;
		while(scanner.hasNextLine()) {
			lineOfText = scanner.nextLine();
			pw.println(count(lineOfText));
		}
		
		scanner.close();
		pw.close();
	}
	
	public static String count(String s) {
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		int[] alphaCount = new int[25];
		String amounts = "";
		
		for (int i = 0; i < s.length() - 1; i++)
			for (int j = 0; j < alpha.length() - 1; j++)
				if (s.substring(i, i + 1).equalsIgnoreCase(alpha.substring(i, i + 1)))
					alphaCount[j]++;
		
		for (int i = 0; i < alphaCount.length; i++)
			amounts += alphaCount[i] + " ";
		
		return amounts;
	}
}
