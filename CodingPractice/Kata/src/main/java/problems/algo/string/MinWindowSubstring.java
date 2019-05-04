package problems.algo.string;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinWindowSubstring {

	public String minWindow(String s, String t) {


		Map<Character, Integer> dictMap = new HashMap<Character,Integer>();
		Map<Character, Integer> windowCounts = new HashMap<Character,Integer>();

		//Crete dictionary map from t - char<->count
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			int cnt = dictMap.getOrDefault(c,0)+1;
			dictMap.put(c,cnt);
		}

		//ans array -> length, l, r
		int [] ans = new int []{-1,0,0};

		int l = 0, r = 0, formed = 0;
		while (r < s.length()) {

			//1. keeping l fixed increase r till we get a formed string
			//2. keeping r fixed increase l till we keep on getting formed string.
			//repeat the process till end of string
			char ch = s.charAt(r);
			int count = windowCounts.getOrDefault(ch, 0);
			windowCounts.put(ch, count + 1);

			//chck if formed for current char
			if(dictMap.get(ch) != null && dictMap.get(ch).intValue() == windowCounts.get(ch).intValue()) {
				formed++;
			}

			while (l <= r && formed == dictMap.size()) {
				ch = s.charAt(l);
				if (ans[0] == -1 || r - l + 1 < ans[0]) {
					ans[0] = r - l + 1;
					ans[1] = l;
					ans[2] = r;
				}

				//check if substring is still formed
				windowCounts.put(ch, windowCounts.get(ch) - 1);
				if(dictMap.get(ch) != null && dictMap.get(ch).intValue() > windowCounts.get(ch).intValue()) {
					formed--;
				}
				l++;
			}
			r++;
		} 
		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
