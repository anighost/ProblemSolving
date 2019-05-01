package problems.algo.string;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutRepeatingChar {
	
	public int lengthOfLongestSubstring(String s) {

		Set<Character> charSet = new HashSet<Character>();
		int i = 0;
		int j = 0;
		int len = s.length();
		int ans = 0;

		while (i < len && j < len) {
			if(!charSet.contains(s.charAt(i))) {
				charSet.add(s.charAt(i++));
				ans = Math.max(ans, (i-j));
			} else {
				charSet.remove(s.charAt(j++));
			}
		}

		return ans;
	}
	public static void main(String[] args) {
		LongestSubStrWithoutRepeatingChar cl = new LongestSubStrWithoutRepeatingChar();
		System.out.println(cl.lengthOfLongestSubstring("abcaacbdb"));
	}

}
