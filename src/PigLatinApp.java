
public class PigLatinApp {

	public static void main(String[] args) {
		System.out.println("Pig Latin Translator\n");
		boolean choice = true;
		while (choice) {
			translateToPigLatin(Console.getString("Enter a line: "));
			if (Console.getString("Continue? (y/n) : ", "y", "n").equals("n")) {
				choice = false;
			}
		}
	}
	
	public static void translateToPigLatin(String input) {
		if (input.charAt(input.length()-1)=='.'||input.charAt(input.length()-1)=='!'||input.charAt(input.length()-1)=='?') {
			input = input.substring(0, input.length()-2);
		}
		String vowels = "aeiou";
		String[] word = input.toLowerCase().split(" ");
		for (int i = 0; i < word.length; i++) {
			if (word[i].matches(".*\\d+.*")||word[i].matches("[@#$%&]*")) {
//				if our word contain a digit or a special character, we do not modify it
			} else {
				if (vowels.contains(String.valueOf(word[i].charAt(0)))) {
					word[i] += "way";
				} else {
					for (int j = 0; j < word[i].length(); j++) {
						if (vowels.contains(String.valueOf(word[i].charAt(j)))) {
							String leadingConsonants = word[i].substring(0, j);
							String everythingElse = word[i].substring(j, word[i].length());
							word[i] = everythingElse+leadingConsonants+"ay";
							break;
						}
					}
				}
			}
		}
		System.out.println(String.join(" ", word));
	}

}
