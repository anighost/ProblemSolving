package problems.algo.array;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/contiguous-array/
 */
public class ContiguousBinaryArray {

    public static int findMaxLength(int[] nums) {
        
    	int sum = 0;
    	int ans = Integer.MIN_VALUE;
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(0, -1);
    	int incr = 0;
    	for (int i = 0; i < nums.length; i++) {
    		
    		incr = nums[i] == 1 ? 1 : -1;
    		sum += incr;
    		
    		if (map.containsKey(sum)) {
    			ans = Math.max(ans, i - map.get(sum));
    		} else {
    			map.put(sum, i);
    		}
    	}
    	
    	return ans == Integer.MIN_VALUE ? 0 : ans;
    	
    }
	
	public static void main(String[] args) {
		int [] nums = new int [] {1,0,1,1,0,1,1};
		System.out.println(findMaxLength(nums));
		
	}

}
