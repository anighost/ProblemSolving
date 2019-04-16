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

//KMP
public class RepeatedSubstring {
	
    static boolean repeatedSubstringPattern(String s) {
    	
    	//construct KMP lps array
    	int len = s.length();
    	int [] lps = new int[len];
    	
    	int i = 1, j = 0;
    	lps[0] = 0;
    	
    	while (i < len) {
    		
    		if (s.charAt(i) == s.charAt(j)) {
    			lps[i] = j + 1;
    			i++;
    			j++;
    		} else {
    			if (j != 0) {
    				j = lps[j - 1];
    			} else {
    				i++;
    			}
    		}
    	}
    	
    	if (lps[len -1] > 0 && len%(len - lps[len -1]) == 0) {
    		return true;
    	} else {
        	return false;
    	}
    }

	
	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("aba"));
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));
		System.out.println(repeatedSubstringPattern("abaabaa"));

	}

}
