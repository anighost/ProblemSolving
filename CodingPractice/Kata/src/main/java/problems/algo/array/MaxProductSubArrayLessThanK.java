package problems.algo.array;

/*
 * https://leetcode.com/problems/subarray-product-less-than-k/
 * 
 * 	Input: nums = [10, 5, 2, 6], k = 100
	Output: 8
	Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
	Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 */
	

public class MaxProductSubArrayLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
    	if (nums.length == 0 || k <=1) {
    		return 0;
    	}
    		
    	int prod = 1;
    	int counter = 0;
		int j = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		//get product
			prod *= nums[i];
    		
    		//expand range
    		while (prod >= k) {
    			prod /= nums[j++];
    		}
    		
    		counter += i - j + 1;
    		
    	}
    	
    	return counter;
    }
    
	public static void main(String[] args) {
		MaxProductSubArrayLessThanK cl = new MaxProductSubArrayLessThanK();
		
		//test1
		int [] nums1 = new int[] {10, 5, 2, 6};
		System.out.println(cl.numSubarrayProductLessThanK(nums1, 100));
		//test2
		int [] nums2 = new int[] {10, 5, 1, 1};
		System.out.println(cl.numSubarrayProductLessThanK(nums2, 100));
		//test3
		int [] nums3 = new int[] {0, 1};
		System.out.println(cl.numSubarrayProductLessThanK(nums3, 1));
	}

}
