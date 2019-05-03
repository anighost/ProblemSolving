package problems.algo.sort;

import problems.algo.utils.CommonUtils;

/*
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public static void sortColors(int[] nums) {

    	int p0 = 0;
    	int p2 = nums.length - 1;
    	int curr = 0;
    	
    	while (curr <= p2) {
    		
    		//num = 0 - swap curr and p0 and increment both
    		//num = 1 - incr curr
    		//num = 2 - swap curr and p2, decrement p2
    		
    		if(nums[curr] == 0) {
    			int tmp = nums[curr];
    			nums[curr++] = nums[p0];
    			nums[p0++] = tmp;
    		} else if (nums[curr] == 2) {
    			int tmp = nums[curr];
    			nums[curr] = nums[p2];
    			nums[p2--] = tmp;
    		} else {
    			curr++;
    		}
    	}
    }

	public static void main(String[] args) {
		int [] nums1 = new int [] {2,0,2,1,1,0};
		sortColors(nums1);
		CommonUtils.printArray(nums1);

	}

}
