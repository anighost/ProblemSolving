package problems.algo.array;
/*
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePath {

    int m_path = 0;
    
    public int uniquePaths(int m, int n) {
        traverse(0,0,m,n);
        return m_path;
    }
    
    private void traverse(int r, int c, int m, int n) {
        
        //check if valid
        if(!(r >=0 && r < m && c >=0 && c < n))
            return;
        
        //check if end of board - break
        if(r == m-1 && c == n-1) {
            m_path++;
            return;
        }
        
        traverse(r+1,c,m,n);
        traverse(r,c+1,m,n);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
