package plpkg;

public class pigLatin {

	public static void main(String[] args) {
		System.out.println(leading("*(&$@#UJGHEi"));
		System.out.println(trailing("h&*f&83"));
		System.out.println(display("!hello master Kelly#$ yay"));
	}

	public static String[] separate(String s) {
		return s.split(" ");
	}
	
	public static boolean isChar(char c) {
		return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
	}
	
	public static boolean isAVowel(String c) {
		String vowels = "aeiou";
		
		for (int i = 0; i < vowels.length() - 1; i++)
			if (c.equalsIgnoreCase(vowels.substring(i, i + 1)))
				return true;
		
		return false;
	}
	
	public static boolean isYConsonant(String s) {
		if (s.charAt(0) == 'Y' || s.charAt(0) == 'y')
			return true;
		
		return false;
	}
	
	public static String leading(String s) {
		String leading = "";
		int idx = 0;
		
		for (int i = 0; i < s.length() - 1; i++)
			if (!isChar(s.charAt(i)))
				idx++;
		
		return leading = s.substring(0, idx);
	}
	
	public static String trailing(String s) {
		String trailing = "";
		int idx = 0;
		
		for (int i = s.length() - 1; i >= 0; i--) 
			if (!isChar(s.charAt(i)))
				idx++;
			else
				break;
		
		return trailing = s.substring(s.length() - idx);
	}
	
	public static String setWord(String s) {
		int idx = 0;
		
		if ((s.substring(0, 1).equalsIgnoreCase("y")) && (s.substring(s.length() - 1).equalsIgnoreCase("y")))
			return s.substring(1);
		else { 
			for (int i = 0; i < s.length() - 1; i++) {
			if (!isAVowel(s.substring(i, i + 1)))
				idx++;
			else
				break;
		}}
		
		return s.substring(idx) + s.substring(0, idx);
	}
	
	public static String setPigWord(String s) {
		String fLetter = s.substring(0, 1);
		String lLetter = s.substring(s.length() - 1);
		
		if (isYConsonant(fLetter))
			return "ay";
		else if (!isAVowel(fLetter) && !isAVowel(lLetter))
			return "ay";
		else if (!isAVowel(fLetter) && isAVowel(lLetter))
			return "ay";
		else if (isAVowel(fLetter) && !isAVowel(lLetter))
			return "ay";
		else 
			return "yay";
	}
	
	public static boolean allNonAlpha(String s) {
		for (int i = 0; i < s.length(); i++)
			if (isChar(s.charAt(i)))
				return false;
		
		return true;
	}
	
	public static String[] convert(String s) {
		String[] words = separate(s);
		
		for (int i = 0; i < words.length; i++) {
			if (allNonAlpha(words[i]))
				break;
			
			String leading = leading(words[i]);
			String trailing = trailing(words[i]);
			
			if (trailing.length() == 0)
				words[i] = words[i].substring(leading.length());
			else
				words[i] = words[i].substring(leading.length() - 1, words[i].length() - trailing.length());
			
			String pigWord = setPigWord(words[i]);
			words[i] = leading + setWord(words[i]) + pigWord + trailing;
		}
		
		return words;
	}
	
	public static String display(String s) {
		String[] words = convert(s);
		String translated = "";
		
		for (int i = 0; i < words.length; i++)
			translated += words[i] + " ";
		
		return translated;
	}
}