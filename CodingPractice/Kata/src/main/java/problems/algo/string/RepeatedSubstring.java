package problems.algo.string;

/**
 * 
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

	Example 1:
	
	Input: "abab"
	Output: True
	Explanation: It's the substring "ab" twice.
	Example 2:
	
	Input: "aba"
	Output: False
	Example 3:
	
	Input: "abcabcabcabc"
	Output: True
	Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 */
public class RepeatedSubstring {
	
    static boolean repeatedSubstringPattern(String s) {
    	
    	//identify the substring
    	StringBuilder sb = new StringBuilder();
    	char initChar = s.charAt(0);
    	boolean isBreak = false;
    	for (int i = 1; i < s.length(); i++) {
    		char currChar = s.charAt(i);
    	}
        
    	
    	return false;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("aba"));
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));

	}

}
