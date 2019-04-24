package problems.algo.backtrack;
/*
 * https://leetcode.com/problems/word-search-ii/
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {

	//	boolean [][] visited;
	Set<String> result = new HashSet<String>();

	public class TrieNode {
		String data = "";
		TrieNode [] children = new TrieNode[26];

	}

	public class Trie {
		TrieNode root = new TrieNode();

		//insert
		public void insert(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				// position ==> c - 'a'
				if (node.children[c-'a'] == null)
					node.children[c-'a'] = new TrieNode();
				node = node.children[c - 'a'];
			}

			node.data = word;
		}

		//search
		public boolean search(String word) {
			TrieNode node = root;

			for (char c : word.toCharArray()) {
				if (node.children[c - 'a'] == null) return false;
				node = node.children[c - 'a'];
			}

			return (node.data.equals(word));
		}

		//startsWith
		public boolean startsWith(String prefix) {
			TrieNode node = root;

			for (char c : prefix.toCharArray()) {
				if (node.children[c - 'a'] == null) return false;
				node = node.children[c - 'a'];
			}

			return true;
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		//    	visited = new boolean[board.length][board[0].length];
		Trie trie = new Trie();
		//create Trie structure - insert into trie
		for (String word : words) {
			trie.insert(word);
		}

		//search
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				search(board, i, j, "", trie);
			}
		}

		return new ArrayList<String>(result);
	}

	private boolean isValid(char[][] board, int r, int c, String s) {

		if (r >= 0 && r < board.length
				&& c >= 0 && c < board[0].length
				&& board[r][c] != '0') {
			return true;
		}

		return false;
	}

	private void search(char[][] board, int r , int c, String s, Trie trie) {

		if (!isValid(board, r, c, s)) return;

		char boardChar = board[r][c];
		s = s+boardChar;

		//check in Trie
		if (!trie.startsWith(s)) return;

		//set visited
		//    	visited[r][c] = true;
		//check for whole word
		//if found - add to output and return

		board[r][c] = '0';
		if(trie.search(s)) {
			result.add(s);
		}

		//recursion
		search(board, r+1, c, s, trie);
		search(board, r-1, c, s, trie);
		search(board, r, c+1, s, trie);
		search(board, r, c-1, s, trie);

		//backtrack 
		//    	visited[r][c] = false;
		board[r][c] = boardChar;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch2 w = new WordSearch2();
		//		Trie trie = w.new Trie();
		//		trie.insert("word");
		//		trie.insert("who");
		//		System.out.println(trie.toString());
		//		System.out.println(trie.search("wh"));
		//		System.out.println(trie.startsWith("h"));

		//a b
		//a a
		char[][] board = new char[][] {{'a','b'},{'a','a'}};
		//		String[] words = new String [] {"aaa","aaab","aaba","aba","baa"};
		String[] words = new String [] {"aaab","aaa"};
		System.out.println(w.findWords(board, words));
	}
}

