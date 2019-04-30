package problems.algo.string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {
	
	int count = 0;
	List<String> strList = new ArrayList<String>();
	
	//Count of palindromic substrings
	public int countSubstrings(String s) {

		for (int i = 0; i < s.length(); i++) {
			expand(s,i,i);
			expand(s,i,i+1);
		}

		return count;
	}
	
	public List<String> getAllSubstring(String s) {
		for (int i = 0; i < s.length(); i++) {
			expand(s, i, i);
			expand(s, i, i+1);
		}
		
		return strList;
	}

	private void expand(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            strList.add(s.substring(l,r+1));
			l--;
			r++;
            count++;
		}
	}

	public static void main(String[] args) {
		PalindromicSubstrings p = new PalindromicSubstrings();
		System.out.println(p.countSubstrings("aaabaaa"));
		p.strList = new ArrayList<String>();
		System.out.println(p.getAllSubstring("aaabaaa"));

	}

}
