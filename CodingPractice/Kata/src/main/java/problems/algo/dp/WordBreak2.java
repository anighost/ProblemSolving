package problems.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

	Note:
	
	The same word in the dictionary may be reused multiple times in the segmentation.
	You may assume the dictionary does not contain duplicate words.
	Example 1:
	
	Input:
	s = "catsanddog"
	wordDict = ["cat", "cats", "and", "sand", "dog"]
	Output:
	[
	  "cats and dog",
	  "cat sand dog"
	]
	Example 2:
	
	Input:
	s = "pineapplepenapple"
	wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
	Output:
	[
	  "pine apple pen apple",
	  "pineapple pen apple",
	  "pine applepen apple"
	]
	Explanation: Note that you are allowed to reuse a dictionary word.
	Example 3:
	
	Input:
	s = "catsandog"
	wordDict = ["cats", "dog", "sand", "and", "cat"]
	Output:
	[]
 *
 */
public class WordBreak2 {
	
    public static List<String> wordBreak(String s, List<String> wordDict) {
    	
    	Set<String> wordSet = new HashSet<String>(wordDict);
    	List<String> [] dp = new ArrayList [s.length() + 1];
    	List<String> start = new ArrayList<String>();
    	start.add("");
    	
    	dp[0] = start;
    	
    	for (int i = 1; i <= s.length(); i++) {
			List<String> list = new ArrayList<String>();
    		for (int j = 0; j < i; j++) {
    			if( dp[j].size() > 0 && wordSet.contains(s.substring(j, i))) {
    				for (String str : dp[j]) {
        				list.add(str + (str.equals("") ? "" : " ") + s.substring(j,i));
    				}
    			}
    		}
    		dp[i] = list;
    	}
    	
    	return dp[s.length()];
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l1 = new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
		System.out.println(wordBreak("catsanddog",l1));

	}

}
