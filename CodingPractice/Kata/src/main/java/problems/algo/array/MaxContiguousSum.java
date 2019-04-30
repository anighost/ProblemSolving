package problems.algo.array;
/*
 * 	https://leetcode.com/problems/maximum-subarray/
 * 	Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * 	which has the largest sum and return its sum.

	Example:
	
	Input: [-2,1,-3,4,-1,2,1,-5,4],
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.
	Follow up:

	If you have figured out the O(n) solution, try coding another solution using 
	the divide and conquer approach, which is more subtle.
 */
public class MaxContiguousSum {

    public int maxSubArray(int[] nums) {
    	
    	//max_till_here
    	//max_sum
    	//keep adding to max_till_here
    	//if nums[i] > max_till here then max_till_here = nums[i]
    	
    	int max_till_here = nums[0];
    	int max_sum = nums[0];
    	
    	for (int i = 1; i < nums.length; i++) {
    		max_till_here += nums[i];
    		max_till_here = Math.max(max_till_here, nums[i]);
    		max_sum = Math.max(max_sum, max_till_here);
    	}
        
    	return max_sum;
    }
    
	public static void main(String[] args) {
		MaxContiguousSum m = new MaxContiguousSum();
		int [] nums = new int [] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(m.maxSubArray(nums));

	}

}
