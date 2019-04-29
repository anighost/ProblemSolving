package problems.algo.string;

/*
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {
	
	int count = 0;
	public int countSubstrings(String s) {

		for (int i = 0; i < s.length(); i++) {
			expand(s,i,i);
			expand(s,i,i+1);
		}

		return count;
	}

	private void expand(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
			l--;
			r++;
            count++;
		}
	}

	public static void main(String[] args) {
		PalindromicSubstrings p = new PalindromicSubstrings();
		System.out.println(p.countSubstrings("aaabaaa"));

	}

}
