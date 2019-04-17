package problems.algo.backtrack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * On an N x N board, the numbers from 1 to N*N are written boustrophedonically 
 * starting from the bottom left of the board, and alternating direction each row.  
 * For example, for a 6 x 6 board, the numbers are written as follows:


	You start on square 1 of the board (which is always in the last row and first column).  
	Each move, starting from square x, consists of the following:
	
	You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, 
	provided this number is <= N*N.
	(This choice simulates the result of a standard 6-sided die roll: 
	ie., there are always at most 6 destinations, regardless of the size of the board.)
	If S has a snake or ladder, you move to the destination of that snake or ladder.  
	Otherwise, you move to S.
	A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  
	The destination of that snake or ladder is board[r][c].
	
	Note that you only take a snake or ladder at most once per move: if the destination to a 
	snake or ladder is the start of another snake or ladder, you do not continue moving.  
	(For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, 
	then you finish your first move at `3`, because you do not continue moving to `4`.)
	
	Return the least number of moves required to reach square N*N.  If it is not possible, return -1.
 *
 */
public class SnakesNLadders {
	
	public static class QEntry {
		
		int v;
		int dist;
		
	}

    //Considering 1D array
    public static int snakesAndLadders(int[][] board) {
    	
    	int h = board.length;
    	int w = board[0].length;
    	
    	//convert to 1D array
    	int [] arr = new int [h*w];
    	int index = 0;
    	int incr = 1;
    	int i = h - 1;
    	int j = 0;
    	while (index < h*w) {
    		
    		int val = board[i][j];
    		if (val == -1) {
        		arr[index++] = val;
    		} else {
        		arr[index++] = val - 1;
    		}
    		
    		if(incr == 1 && j == w - 1) {
    			incr = -1;
    			i--;
    		} else if (incr == -1 && j == 0) {
    			incr = 1;
    			i--;
    		} else {
    			j += incr;
    		}
    		
    	}
        
    	return getMinDiceThrows(arr);
    }
    
    //Considering 1D array
    static int getMinDiceThrows(int board[]) {
    	
    	int n = board.length;
    	Queue<QEntry> queue = new LinkedList<QEntry>();
    	
    	boolean [] visited = new boolean [n];
    	
    	visited[0] = true;
    	
    	QEntry qe = new QEntry();
    	qe.v = 0;
    	qe.dist = 0;
    	
    	queue.add(qe);
    	
    	while (!queue.isEmpty()) {
    		
    		qe = queue.remove();
    		
    		int v = qe.v;
    		
    		//break condition
    		if(v == n -1) {
    			return qe.dist;
    		}
    		
    		for (int i = v+1; i <= v+6 && i < n; i++) {
    			
    			if (!visited[i]) {
    				QEntry a = new QEntry();
    				a.dist = qe.dist+1;
    				visited[i] = true;
    				
    				//set v
    				if(board[i] == -1) {
    					a.v = i;
    				} else {
    					a.v = board[i];
    				}
    	    		queue.add(a);
    			}
    		}
    	}
    	
    	return -1;
    }
    

	public static void main(String[] args) {
		
		int [][] board = new int [][] {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
		
        int N = 30; 
        int moves[] = new int[N]; 
        for (int i = 0; i < N; i++) 
            moves[i] = -1; 
  
        // Ladders 
        moves[2] = 21; 
        moves[4] = 7; 
        moves[10] = 25; 
        moves[19] = 28; 
  
        // Snakes 
        moves[26] = 0; 
        moves[20] = 8; 
        moves[16] = 3; 
        moves[18] = 6; 
        
        System.out.println(getMinDiceThrows(moves));
		
		System.out.println(snakesAndLadders(board));
	}

}
