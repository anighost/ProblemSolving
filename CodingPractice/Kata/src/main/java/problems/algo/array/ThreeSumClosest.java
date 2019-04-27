package problems.algo.array;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/3sum-closest/
 * 
 * Given an array nums of n integers and an integer target, 
 * find three integers in nums such that the sum is closest to target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

	Example:
	
	Given array nums = [-1, 2, 1, -4], and target = 1.
	
	The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	
	public int threeSumClosest(int[] nums, int target) {
		
		//unsorted array
		int len = nums.length;
		Arrays.sort(nums);
		
		//-4,-1,1,2

		int ans = nums[0]+nums[1]+nums[2];
		for (int i = 0; i < len -2; i++) {
			
			int l = i+1;
			int r = len - 1;
			while (l < r) {
				
				int s = nums[i] + nums[l] + nums[r];
				if(Math.abs(target - s) < Math.abs(target - ans)) {
					ans = s;
				}
				
				if (ans == target) return ans;
				if(s < target) {
					l++;
				} else {
					r--;
				}
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int [] {-1, 2, 1, -4};
		
		ThreeSumClosest cl = new ThreeSumClosest();
		System.out.println(cl.threeSumClosest(nums, 1));
	}

}
