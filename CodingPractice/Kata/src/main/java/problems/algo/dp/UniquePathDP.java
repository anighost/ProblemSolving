package problems.algo.dp;

/*
 *  * https://leetcode.com/problems/unique-paths/

 */
public class UniquePathDP {
	
	int [][] memRes;
	
    public int uniquePaths(int m, int n) {
    	memRes = new int[m][n];
    	return numWays(0, 0, m, n);
    }
    
    
    private int numWays(int r, int c, int m, int n) {
    	
    	int res = 0;
    	//if we already know number of ways ni curr cell
    	if(memRes[r][c] > 0) {
    		return memRes[r][c];
    	}
    	
    	//check if end of board
    	if (r == m-1 && c == n-1) {
    		return 1;
    	}
    	
        if(r==m-1){
            res=numWays(r,c+1,m,n);
        }
        else if(c==n-1){
            res=numWays(r+1,c,m,n);
        }
        else{
            res=numWays(r+1,c,m,n);
            res=res+numWays(r,c+1,m,n);
        }
        memRes[r][c]=res;
     return res;
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePathDP u = new UniquePathDP();
		System.out.println(u.uniquePaths(3, 2));

	}

}
