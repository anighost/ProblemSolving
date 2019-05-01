package problems.algo.array;

import java.util.HashMap;
import java.util.Map;

/*
 * 	https://leetcode.com/problems/subarray-sum-equals-k/
 * 	
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

	Example 1:
	Input:nums = [1,1,1], k = 2
	Output: 2
 */
public class SubArraySumsEqualsK {

    public int subarraySum(int[] nums, int k) {
        
    	int counter = 0;
    	for (int l = 0; l <nums.length; l++) {
    		int sum = 0;
    		for (int r = l; r <nums.length; r++) {
    			
    			sum += nums[r];
    			if(sum == k) counter++;
    		}
    	}
    	
    	return counter;    	
    }

    public int subarraySumOpt(int[] nums, int k) {
        
    	int counter = 0;
    	int sum = 0;
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(0, 1);
    	
    	for (int i = 0; i < nums.length; i++) {
    		
    		sum += nums[i];
    		
    		if (map.get(sum -k) != null) {
    			counter+= map.get(sum-k);
    		}
    		
    		map.put(sum, map.getOrDefault(sum, 0)+1);
    	}
    	
    	return counter;    	
    }

    public static void main(String[] args) {
		SubArraySumsEqualsK cl = new SubArraySumsEqualsK();
		
		//test1
		int [] a1 = new int [] {1,1,1};
		System.out.println(cl.subarraySum(a1, 2));
		System.out.println(cl.subarraySumOpt(a1, 2));

		//test1
		int [] a2 = new int [] {3,4,7,2,-3,1,4,2};
		System.out.println(cl.subarraySum(a2, 7));
		System.out.println(cl.subarraySumOpt(a2, 7));
	}

}
