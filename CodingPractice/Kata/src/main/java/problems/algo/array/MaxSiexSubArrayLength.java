package problems.algo.array;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 */
public class MaxSiexSubArrayLength {

    public int maxSubArrayLenBrute(int[] nums, int k) {
        
        int maxSize = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                
                if(sum == k) {
                    maxSize = Math.max(maxSize, j - i + 1);
                }
            }
        }
        return maxSize == Integer.MIN_VALUE ? 0 : maxSize;
    }

    public static int maxSubArrayLen(int[] nums, int k) {
        
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
//            if (sum == k) max = i + 1;
            if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
	
	public static void main(String[] args) {
		
		int [] nums = new int [] {-2, -1, 2, 1};
		System.out.println(maxSubArrayLen(nums, 1));

		int [] nums2 = new int [] {-2, -1, 2, -1};
		System.out.println(maxSubArrayLen(nums2, 0));
	}

}
