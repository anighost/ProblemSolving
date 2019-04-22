package problems.algo.backtrack;

//LeetCode : https://leetcode.com/problems/word-search/

public class FindStringInMatrix2 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(search(board,word,i,j,0)) {
                    return true;
                } 
            }
        }
        
        return false;
    }
    
    private boolean isValid(int r, int c, char[][] board, String word, int pos) {        
        if(r >= 0 && r < board.length && c >= 0 && c < board[r].length && board[r][c] == word.charAt(pos)) return true;
        return false;
    }
    
    private boolean search(char[][] board, String word, int r, int c, int pos) {
        // break condition - invalid
        if(!isValid(r,c,board,word,pos)) return false;
        
        //break condition - last index of string
        if(pos == word.length() -1) return true;
        
        //set visited
        board[r][c] = '0';
        //search next cells
        if(search(board,word,r+1,c,pos+1)) return true;
        if(search(board,word,r-1,c,pos+1)) return true;
        if(search(board,word,r,c+1,pos+1)) return true;
        if(search(board,word,r,c-1,pos+1)) return true;
        
        //backtrack
        board[r][c] = word.charAt(pos);
        
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = 
			{ 
					{ 'A','B','C','E'},
					{ 'S','F','C','S'}, 
					{ 'A','D','E','E'}				
					};

		char[][] matrix1 = 
			{ 
					{ 'B'},
					{'A'},
					{'B'},
					};
		
		FindStringInMatrix2 f = new FindStringInMatrix2();
		System.out.println(f.exist(matrix, "ABCCED"));
		System.out.println(f.exist(matrix1, "BBABAB"));

	}

}
