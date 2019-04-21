package problems.algo.backtrack;

public class FindStringInMatrix2 {
    
    
    public boolean exist(char[][] board, String word) {
       
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length ; j++) {
            	boolean isMatch = search(board, word, i, j, 0);
                if (isMatch) {
                	return true;
                }
            }
        }
        
        return false;
        
    }
    
    public boolean search(char[][] board, String word, int row, int col, int pos) {

        if(row < 0 || col < 0 || row >= board.length || col >= board[row].length || pos >= word.length()
                ||word.charAt(pos) != board[row][col]) {
            return false;
        }
        if(pos == word.length() - 1) {
            return true;
        }
        board[row][col] = '0';
        if(search(board, word, row + 1, col, pos + 1)) return true;
        if(search(board, word, row, col + 1, pos + 1)) return true;
        if(search(board, word, row, col - 1, pos + 1)) return true;
        if(search(board, word, row - 1, col, pos + 1)) return true;
        board[row][col] = word.charAt(pos);
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
