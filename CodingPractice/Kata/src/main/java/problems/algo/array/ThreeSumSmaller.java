package problems.algo.array;

import java.util.Arrays;

public class ThreeSumSmaller {

	public int threeSumSmaller(int[] nums, int target) {
		int res = 0;
		int len = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < len-2; i++) {
			int l = i+1;
			int r = len - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if(sum < target) {
					res = res + (r -l);
					l++;
				} else {
					r--;
				}
			}
		}
		
		return res;
	}
	public static void main(String[] args) {
		ThreeSumSmaller cl = new ThreeSumSmaller();
		int [] nums = new int [] {-2,0,1,3};
		System.out.println(cl.threeSumSmaller(nums, 2));

	}

}
