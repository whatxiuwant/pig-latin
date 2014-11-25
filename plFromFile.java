package plpkg;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

//import java.io.*;

public class plFromFile {

	public static void main(String[] args) throws IOException {
		//IOException (runtime error, DNE)
		File input = new File("ioExample.txt");
		if (!input.exists()) {
			System.out.println("ioExample.txt does not exist.");
			System.exit(1);
		}
		
		Scanner scanner = new Scanner(input);
		//System.exit(0); means everything runs fine
		
		File output = new File("translateIOExample.txt");
		if (output.exists()) {
			System.out.println("translatedIOExample.txt already exists.");
			System.exit(2);
		}
		 
		PrintWriter pw = new PrintWriter(output);
		String lineOfText;
		while(scanner.hasNextLine()) {
			lineOfText = scanner.nextLine();
			pw.println(pigLatin.display(lineOfText));
		}
		
		scanner.close();
		pw.close(); 
	}
}
