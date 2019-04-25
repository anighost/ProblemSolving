package problems.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	Note:
	
	The same word in the dictionary may be reused multiple times in the segmentation.
	You may assume the dictionary does not contain duplicate words.
	Example 1:
	
	Input: s = "leetcode", wordDict = ["leet", "code"]
	Output: true
	Explanation: Return true because "leetcode" can be segmented as "leet code".
	Example 2:
	
	Input: s = "applepenapple", wordDict = ["apple", "pen"]
	Output: true
	Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
	             Note that you are allowed to reuse a dictionary word.
	Example 3:
	
	Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	Output: false
 *
 */
public class WordBreak1 {

    public static boolean wordBreak(String s, List<String> wordDict) {
    	
    	if (s == null || s.isEmpty()) {
    		return false;
    	}
    	
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(0);
    	
    	boolean[] visited = new boolean[s.length()];
    	
    	while (!queue.isEmpty()) {
    		
    		int start = queue.remove();
    		
    		if(!visited[start]) {
    			
    			for (int end = start+1; end <= s.length(); end++) {
    				
    				//check match
    				if(wordDict.contains(s.substring(start, end))) {
    					//add to queue
    					queue.offer(end);
        				//return - break condition - full string traversal
        				if (end == s.length()) {
        					return true;
        				}
    				}
    			}    			
    		}
    		
    		visited[start] = true;
    	}
    	
    	return false;
    }
    
    public static boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


	public static void main(String[] args) {
		
		List<String> l1 = new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
		System.out.println(wordBreak("catsandog",l1));
		
		List<String> l2 = new ArrayList<String>(Arrays.asList("leet", "code"));
		System.out.println(wordBreak("leetcode",l2));

		List<String> l3 = new ArrayList<String>(Arrays.asList("apple", "pen"));
		System.out.println(wordBreak("applepenapple",l3));

		List<String> l4 = new ArrayList<String>(Arrays.asList("bc", "cb"));
		System.out.println(wordBreak("ccbb",l4));

		List<String> l5 = new ArrayList<String>(Arrays.asList("leet", "etc"));
		System.out.println(wordBreakDP("leetc",l5));

		List<String> l11 = new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
		System.out.println(wordBreakDP("catsandog",l11));
		
		List<String> l21 = new ArrayList<String>(Arrays.asList("leet", "code"));
		System.out.println(wordBreakDP("leetcode",l21));

		List<String> l31 = new ArrayList<String>(Arrays.asList("apple", "pen"));
		System.out.println(wordBreakDP("applepenapple",l31));

		List<String> l41 = new ArrayList<String>(Arrays.asList("bc", "cb"));
		System.out.println(wordBreakDP("ccbb",l41));
	}

}
