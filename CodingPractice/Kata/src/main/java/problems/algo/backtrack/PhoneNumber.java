package problems.algo.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

	A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
	
	
	
	Example:
	
	Input: "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	Note:
	
	Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class PhoneNumber {
	
	Map<String,String> charMap = new HashMap<String, String>();
	List<String> outList = new ArrayList<String>();
	
	public PhoneNumber() {
		charMap.put("2", "abc");
		charMap.put("3", "def");
		charMap.put("4", "ghi");
		charMap.put("5", "jkl");
		charMap.put("6", "mno");
		charMap.put("7", "pqrs");
		charMap.put("8", "tuv");
		charMap.put("9", "wxyz");
		charMap.put("*", "+");
		charMap.put("0", " ");
		
	}
	
	/**
	 * 
	 * 23  2 => abc 3 => def
	 * a + combination(def)
	 * b + combination(def)
	 * c + combination(def)
	 * 
	 * 
	 */

    public List<String> letterCombinations(String digits) {
    	
    	
    	if (digits != null && !digits.isEmpty()) {
    		getCombination("",digits);
    	}
    	
    	return outList;
        
    }
    
    public void getCombination(String combination, String digits) {
    	
    	//break
    	//explored all digits
    	if(digits.length() == 0) {
    		outList.add(combination);
    	} else {
        	String checkDigit = digits.substring(0,1);
        	String letters = charMap.get(checkDigit);
        	
        	for (int i = 0; i < letters.length(); i++) {
        		String letter = letters.substring(i,i+1);
        		getCombination(combination+letter,digits.substring(1));
        		
        	}
    	}
    }
    
    
	public static void main(String[] args) {
		
		PhoneNumber p = new PhoneNumber();
		System.out.println(p.letterCombinations("23"));
		
	}

}
