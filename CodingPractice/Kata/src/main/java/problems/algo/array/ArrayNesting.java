package problems.algo.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 
 *	A zero-indexed array A of length N contains all integers from 0 to N-1. 
 *	Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } 
 *	subjected to the rule below.

	Suppose the first element in S starts with the selection of element A[i] of index = i, 
	the next element in S should be A[A[i]], and then A[A[A[i]]]
 	By that analogy, we stop adding right before a duplicate element occurs in S.
	
	Example 1:
	
	Input: A = [5,4,0,3,1,6,2]
	Output: 4
	Explanation: 
	A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
	
	One of the longest S[K]:
	S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
	 
	Note:
	
	N is an integer within the range [1, 20,000].
	The elements of A are all distinct.
	Each element of A is an integer within the range [0, N-1].
 */
public class ArrayNesting {
	
    private static int arrayNesting(int[] nums) {
    	
    	int k = 0;
    	boolean [] visited = new boolean [nums.length];
    	
    	for (int i = 0; i < nums.length; i++) {
    		
    		if (!visited[i]) {
        		Set<Integer> s = new HashSet<Integer>();
        		
        		int j = i;
        		while (!s.contains(nums[j])) {
        			s.add(nums[j]);
        			j = nums[j];
        			visited[j] = true;
        		}
        		
        		k = Math.max(k, s.size());
    		}
    	}
    	
    	return k;
    }

    private static int arrayNestingOpt(int[] nums) {
    	
    	int k = 0;

    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] >= 0) {
        		int j = i;
        		int count = 0;
        		while (nums[j] >= 0) {
        			int temp = j;
        			j = nums[j];
        			nums[temp] = -1;
        			count++;
        		}
        		
        		k = Math.max(k, count);
    		}
    	}
    	
    	return k;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums1 = {5,4,0,3,1,6,2};
		System.out.println("Expected result : 4 Actual resul : "+arrayNesting(nums1));
		System.out.println("Expected result : 4 Actual resul : "+arrayNestingOpt(nums1));
		int [] nums2 = {0};
		System.out.println("Expected result : 1 Actual resul : "+arrayNesting(nums2));
		System.out.println("Expected result : 1 Actual resul : "+arrayNestingOpt(nums2));

	}

}
