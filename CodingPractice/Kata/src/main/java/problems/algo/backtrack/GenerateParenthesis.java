package problems.algo.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
	For example, given n = 3, a solution set is:

	[
	  "((()))",
	  "(()())",
	  "(())()",
	  "()(())",
	  "()()()"
	]
 *
 */
public class GenerateParenthesis {
	final static String openParenthesis = "(";
	final static String closeParenthesis = ")";
	
	public static List<String> generateParenthesis(int n) {
		
		List<String> outList = new ArrayList<String>();
		
		backTrack(0, 0, "", n, outList);
		
		return outList;

	}
	
	static void backTrack(int open, int close, String curr, int len, List<String> outList) {
		
		//break
		if(curr.length() == len*2) {
			outList.add(curr);
		}
		
		if (open < len) {
			backTrack(open+1, close, curr+"(", len,outList);
		}
		
		if (close < open) {
			backTrack(open, close+1, curr+")", len,outList);			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(3));

	}

}
