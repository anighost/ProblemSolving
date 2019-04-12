package problems.algo.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public  class ReverseVowels {

	public static String reverseVowels(String s) {

		if(s == null || s.isEmpty()) {
			return "";
		}

		Set<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u',
				'A','E','I','O','U'));

		char[] ch = s.toCharArray();
		int i = 0; 
		int j = s.length() - 1;

		while (i < j) {
			if (!vowelSet.contains(ch[i])) {
				i++;
			}
			if (!vowelSet.contains(ch[j])) {
				j--;
			}

			if (vowelSet.contains(ch[i]) && vowelSet.contains(ch[j])) {
				char tmp = ch[i];
				ch[i] = ch[j];
				ch[j] = tmp;
				i++;j--;

			}
		}

		return String.valueOf(ch);                                  
	}

	public static void main(String[] args) {
		String str = "hello";
		System.out.println(reverseVowels(str));

	}

}
