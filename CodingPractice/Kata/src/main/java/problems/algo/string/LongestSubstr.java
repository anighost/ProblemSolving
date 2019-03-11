package problems.algo.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author anghosh
 * Given a string, find the length of the longest substring without repeating characters.
 *
 *Example 1:

		Input: "abcabcbb"
		Output: 3 
		Explanation: The answer is "abc", with the length of 3. 
		Example 2:
		
		Input: "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
		Example 3:
		
		Input: "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3. 
        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class LongestSubstr {
	
	private static int getSubstr(String s) {
		
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
		
		return ans;
	}
	
	public static void main(String [] args) {
		String instr1 = "abcabcbb";
		String instr2 = "bbbbb";
		String instr3 = "pwwkew";
		String instr4 = "aab";
		
		System.out.println("Expected : 3 Actual : "+getSubstr(instr1));
		System.out.println("Expected : 1 Actual : "+getSubstr(instr2));
		System.out.println("Expected : 3 Actual : "+getSubstr(instr3));
		System.out.println("Expected : 2 Actual : "+getSubstr(instr4));
		
	}

}
