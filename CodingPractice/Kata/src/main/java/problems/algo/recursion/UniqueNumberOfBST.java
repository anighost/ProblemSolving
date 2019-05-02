package problems.algo.recursion;

/*
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueNumberOfBST {
	/*
	 * G(n) -> ans
	 * Sum(F(i,n)) {for i = 1 ...n} = G(n)
	 * F(i,n) = G(i-1) * G(n-i)
	 * 
	 *  => G(n) = Sum(G(i-1) * G(n-i)) {i = 1..n}
	 */
    public int numTrees(int n) {
    	
    	int [] G = new int [n+1];
    	G[0] = 1;
    	G[1] = 1;
    	
    	for (int i = 2; i <= n; i++) {
    		for (int j = 1; j <= i; j++) {    			
    			G[i] += G[j-1] * G[i - j];
    		}
    	}
    	return G[n];
        
    }


	public static void main(String[] args) {
		UniqueNumberOfBST cl = new UniqueNumberOfBST();
		System.out.println(cl.numTrees(3));

	}

}
