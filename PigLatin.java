package stpkg;

public class PigLatin {

	/*
	 * If "y" is the first letter, it is a consonant. Otherwise, "y" is a vowel.
	 * All leading consonants are moved to the end of the word, followed by the letters "ay"
	 * If the word begins with a vowel and ends in a consonant, "ay" is added to the end of the word
	 * If the word begins with a vowel and ends in a vowel, "yay" is added to the end of the word, unless the resulting word would end in "yyay".
	 * In this case, only "ay" is added to the end of the word.
	 */
	
	public static void main(String[] args) {
		String str = "Kelly loves Java, but not this class.";
		System.out.println(display(pigWord(str)));
	}
	
	public static String beginPigLatin(String s) {
		String vowels = "aeiou";
		int idx = 1;
		
		for (int i = 0; i < s.length()-1; i++)
			if (s.substring(i, i+1).equalsIgnoreCase(vowels.substring(i, i+1)))
				idx++;
		
		String fLetter = s.substring(0, idx);
		String[] words = s.split(fLetter);
		
		return s = words[1] + fLetter;
	}
	
	public static String[] separate(String s) {
		String[] words = s.split(" ");
		
		return words;
	}
	
	public static boolean isFirstLetterVowel(String s) {
		String vowels = "aeiou";
		
		for (int i = 0; i < vowels.length(); i++)
			if (s.substring(0, 1).equalsIgnoreCase(vowels.substring(i, i+1)))
				return true;
		return false;
	}
	
	public static boolean isLastLetterVowel(String s) {
		String vowels = "aeiou";
		
		for (int i = 0; i < vowels.length(); i++)
			if (s.substring(s.length()-1).equalsIgnoreCase(vowels.substring(i, i+1)))
				return true;
		return false;
	}
	
	public static boolean checkYyay(String s) {
		return s.indexOf("yyay") >= 0;
	}
	
	public static String[] pigWord(String s) {
		String[] words = separate(s);
		
		for (int i = 0; i < words.length; i++) {
			words[i] = beginPigLatin(words[i]);
		
			if (isFirstLetterVowel(s) && isLastLetterVowel(s)) {
				words[i] += "yay";	//exception for y
				if (checkYyay(words[i]))
					words[i].replace("yyay", "ay");
			}
			else if (isFirstLetterVowel(s) && !isLastLetterVowel(s))
				words[i] += "ay";
			else if (!isFirstLetterVowel(s) && isLastLetterVowel(s))
				words[i] += "ay";
			if (!isFirstLetterVowel(s) && !isLastLetterVowel(s))
				words[i] += "ay";
		}
		
		return words;
	}
	
	public static String display(String[] words) {
		String phrase = "";
		
		for (int i = 0; i < words.length; i++) {
			phrase += words[i] + " ";
		}
		
		return phrase;
	}
}
