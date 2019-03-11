package problems.algo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 *	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	
	Example:
	
	Given nums = [2, 7, 11, 15], target = 9,
	
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].

 */

public class TwoSum {
	
    public static int[] twoSum(int[] nums, int target) {
        int [] sumArray = new int [2];
        
        for (int i = 0; i < nums.length; i++) {
        	int j = i + 1;
        	
        	while (j < nums.length) {
        		if (nums[i] + nums[j] == target) {
        			sumArray[0] = i;
        			sumArray[1] = j;
        			return sumArray;
        		}
        		j++;
        	}
        }
        
        return sumArray;
    }

    public static int[] twoSumOpt(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
        	int complement = target - nums[i];
        	
        	if (numMap.get(complement) != null) {
        		return new int [] {numMap.get(complement), i};
        	}
        	
        	numMap.put(nums[i], i);
        	
        }
        
        throw new IllegalArgumentException("No Solution");
        
    }

//    public static int[] twoSumOptWOHash(int[] nums, int target) {
//        Arrays.sort(nums);
//        int len = nums.length;
//        int i = 0;
//        int j = len - 1;
//        int [] out = new int[2];
//        
//        while(i < j) {
//            if(nums[i]+nums[j] == target) {
//                out[0] = i;
//                out[1] = j;
//                return out;
//            }
//            
//            if(nums[i]+nums[j] > target) {
//                j--;
//            } else {
//                i++;
//            }
//        }
//        
//        throw new IllegalArgumentException("No Solution");
//        
//    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums1 = {2, 7, 11, 15};
		int target1 = 9;
		int [] return1 = twoSum(nums1, target1);
		System.out.println(return1[0] + " , "+ return1[1]);

		int [] return2 = twoSumOpt(nums1, target1);
		System.out.println(return2[0] + " , "+ return2[1]);

		int [] nums3 = {3,2,4};
		int target3 = 6;
		int [] return3 = twoSumOpt(nums3, target3);
		System.out.println(return3[0] + " , "+ return3[1]);
	}

}
