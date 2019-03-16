package problems.algo.string;

public class FindStringInMatrix2 {
    
    public int [][] visited;
    public int[] rows = new int [] {0,0,-1,1};
    public int[] cols = new int [] {1,-1,0,0};
    
    
    public boolean exist(char[][] board, String word) {

    	visited = new int[board.length][board[0].length];
       
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length ; j++) {
            	boolean isMatch = search(board, 0, i, j, word);
                if (isMatch) {
                	return true;
                }
            }
        }
        
        return false;
        
    }
    
    public boolean search(char[][] board, int pos, int row, int col, String word) {

    	//Validate inputs
    	if (word == null || word.isEmpty() || board.length == 0) {
    		return false;
    	}
    	
        //Return in case of mismatch or cell already visited
        if(board[row][col] != word.charAt(pos) 
            || visited[row][col] > 0) {
            return false;
        }
        
        //At this point board[row][col] already matches with word.charAt(pos)
        //Return if whole word is found
        if(pos == word.length()-1) {
            return true;
        }

        //mark visited matrix
        visited[row][col] = 1;
        
//        //check right
//        if(col+1 < board[row].length 
//            && search(board, pos+1, row, col+1, word)) {
//            return true;
//        }
//        
//        //check left
//        if(col-1 >= 0 
//            && search(board, pos+1, row, col-1, word)) {
//            return true;
//        }
//
//        //check up
//        if(row-1 >= 0
//            && search(board, pos+1, row-1, col, word)) {
//            return true;
//        }
//
//        //check down
//        if(row+1 < board.length 
//            && search(board, pos+1, row+1, col, word)) {
//            return true;
//        }
        

        //Check 4 directions
        for (int k = 0; k < 4; k++) {
        	int nrow = row + rows[k];
        	int ncol = col + cols[k];
        	
        	if(nrow < board.length && nrow >= 0 && ncol < board[nrow].length && ncol >=0
                  && search(board, pos+1, nrow, ncol, word)) {
                  return true;
              }        	
        }
        //backtrack and reset visited matrix
        visited[row][col] = 0;
        
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
//		System.out.println(f.exist(matrix, "ABCCED"));
		System.out.println(f.exist(matrix1, "BBABAB"));

	}

}
