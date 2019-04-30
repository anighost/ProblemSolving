
/*
 * https://leetcode.com/problems/subarray-product-less-than-k/
 */
	

public class MaxProductSubArrayLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
    	int prod = 1;
    	int counter = 0;
		int j = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		//get product
			prod *= nums[i];
    		
    		//expand range
    		while (prod >= k) {
    			prod /=
    		}
    		
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
