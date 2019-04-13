package problems.algo.dp;

/**
 * 
 * 	You are climbing a stair case. It takes n steps to reach to the top.

	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	
	Note: Given n will be a positive integer.
	
	Example 1:
	
	Input: 2
	Output: 2
	Explanation: There are two ways to climb to the top.
	1. 1 step + 1 step
	2. 2 steps
	Example 2:
	
	Input: 3
	Output: 3
	Explanation: There are three ways to climb to the top.
	1. 1 step + 1 step + 1 step
	2. 1 step + 2 steps
	3. 2 steps + 1 step
 *
 */

public class ClimbStairs {
	//way(n) = way(n-1) + way(n-2)

    public int climbStairs(int n) {
        
    	//return recurWays(n);
    	return dpWays(n);
    }
    
    //Using Recursion
    public int recurWays(int n) {
    	//recursion break
    	if (n <= 1) {
    		return 1;
    	}
    	//recursion
    	return recurWays(n - 1) + recurWays(n - 2);
    }
    
    
    //Using DP
    public int dpWays(int n) {
    	int n1 = 0;
    	int n2 = 1;
    	int curr = 1;
    	int i = 0;
    	while(i < n) {
    		curr = n1 + n2;
    		n1 = n2;
    		n2 = curr;
    		i++;
    	}
    	return curr;
    }

	public static void main(String[] args) {
		ClimbStairs cl = new ClimbStairs();
		
		System.out.println(cl.climbStairs(3));

	}

}
