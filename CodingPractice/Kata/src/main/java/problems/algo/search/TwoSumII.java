package problems.algo.search;

/**
 * 
 *	https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

public class TwoSumII {
	
    public static int[] twoSum(int[] numbers, int target) {
        
    	int i = 0;
    	int len = numbers.length;
    	int j = len - 1 ;
    	
    	while (i < j) {
    		
    		if(numbers[i] + numbers[j] == target) {
    			return new int [] {i+1,j+1};
    		}
    		
    		if (numbers[i] + numbers[j] < target) {
    			i++;
    		} else {
    			j--;
    		}
    	}
    	
    	return null;
    }


    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums1 = {2, 7, 11, 15};
		int target1 = 9;
		int [] return1 = twoSum(nums1, target1);
		System.out.println(return1[0] + " , "+ return1[1]);

	}

}
