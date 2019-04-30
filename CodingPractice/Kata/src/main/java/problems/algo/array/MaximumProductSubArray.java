package problems.algo.array;

/*
 * 	https://leetcode.com/problems/maximum-product-subarray/
 
 * 	Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

	Example 1:
	
	Input: [2,3,-2,4]
	Output: 6
	Explanation: [2,3] has the largest product 6.
	Example 2:
	
	Input: [-2,0,-1]
	Output: 0
	Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

public class MaximumProductSubArray {

	/*
	 * max = 2, min = 2, a = 2 => res = 2
	 * max = 6, min = 2, a = 3 => res = 6
	 * max = max(-12, -2, -4) = -2, min = min(-12,-2,-4) = -12 => res = 6
	 * max = max(-12, -2, -4) = 6, min = min(-12,-2,6) = -2 => res = 6 
	 * 
	 */
    public int maxProduct(int[] nums) {
        
    	int max = nums[0], min = nums[0], res = nums[0];
    	
    	for (int i = 1; i < nums.length; i++) {
    		int tmp = max;
    		max = Math.max(Math.max(max*nums[i], min * nums[i]), nums[i]);
    		min = Math.min(Math.min(tmp*nums[i], min * nums[i]), nums[i]);
    		res = Math.max(max, res);
    	}
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaximumProductSubArray m = new MaximumProductSubArray();
		int [] nums1 = new int [] {2,3,-2,4};
		System.out.println(m.maxProduct(nums1));
		int [] nums2 = new int [] {-2,0,-1};
		System.out.println(m.maxProduct(nums2));
		int [] nums3 = new int [] {-2,3,-4};
		System.out.println(m.maxProduct(nums3));
	}

}
