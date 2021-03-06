package problems.algo.string;

import java.util.HashSet;
import java.util.Set;

/* Find first recurring character in a String
 * Example: 
 * 	1. "ABCA" -> "A" 
 * 	2. "BCABA" -> "B"
 * 	3. "ABC" -> "Not Found"
 */
public class RecurringChar {
	
	public static String findRecurring(String inputStr) {
		
		/*
		 * 1. Create Empty String
		 * 2. Iterate though each character in input String. Find the character in checkString.
		 * 3. If exists return the character  
		 * 4. If reach the end of String, return "Not Found".
		 */
		String notFoundStr = "Not Found";
		Set<Character> checkSet = new HashSet<>();
		
		for (int i = 0; i < inputStr.length(); i++) {
			Character ch = inputStr.charAt(i);
			if (checkSet.contains(ch)) {//Character Exists. Return
				return Character.toString(ch);
			} 
			//Does not exist. Add character to checkString
			checkSet.add(ch);
		}
		
		return notFoundStr;
		
	}
	
	public static void main(String [] args) {
		String input1 = "ABCA";
		String input2 = "BCABA";
		String input3 = "ABC";
		
		//Recurring
		System.out.println("Output 1: "+ findRecurring(input1));
		System.out.println("Output 2: "+ findRecurring(input2));
		System.out.println("Output 3: "+ findRecurring(input3));
		
	}

}
