package problems.algo.string;

/*
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {

	//example: "bbbab"
	
	// f(i,j) = 2 + f (i+1, j-1) (if s.charAt(i) == s.charAt(j)
	//			ELSE MAX(f(i,j-1), f(i+1,j))
	//base : i ==j => return 1, i> j => return 0;
	int [][] mem;
	public int longestPalindromeSubseq(String s) {
		mem = new int [s.length()][s.length()];
		return lps(s,0,s.length()-1);
	}
	
	private int lps(String s, int i , int j) {
		
		//base
		if(i > j) {
			return 0;
		}
		if(mem[i][j] > 0) {
			return mem[i][j];
		}
		
		if (i == j) {
			mem[i][j] = 1;
		} else if (s.charAt(i) == s.charAt(j)) {
			mem[i][j] = 2 + lps(s, i+1, j-1);
		} else {
			mem[i][j] = Math.max(lps(s, i+1, j),lps(s, i, j-1));
		}
		
		return mem[i][j];
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence cl = new LongestPalindromicSubsequence();
		System.out.println(cl.longestPalindromeSubseq("a"));
		System.out.println();
	}

}
