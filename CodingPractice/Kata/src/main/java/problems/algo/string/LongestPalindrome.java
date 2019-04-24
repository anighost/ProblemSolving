package problems.algo.string;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 */

public class LongestPalindrome {

	public String longestPalindrome(String s) {

		//baabxyxddvc

		if (s == null || s.length() < 1) return "";
		int start = 0;
		int end = 0;

		//1. check position i & i
		//2. check position i and i+1

		for (int i = 0; i < s.length(); i++) {
			//check for odd length palindrome
			int l1 = expand(s,i,i);
			//check for even length palindrome
			int l2 = expand(s,i,i+1);
			int len = Math.max(l1,l2);

			if(len > end - start) {
				start = i - (len -1)/2;
				end = i + len/2;
			}
		}

		return s.substring(start, end+1);
	}

	//2. expand(i,j) ==> Assume string in between in palindrome
	//2.1. check if s[i++] == s[j--] and so on
	//2.2. else return length => j - i - 1

	private int expand(String s, int l, int r) {
		//validate
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}

		return r -l -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
