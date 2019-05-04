package problems.algo.array;

/*
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinSubArraySum {

	public static int minSubArrayLen(int s, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		int sum = 0;
		int l = 0, r = 0;
		while (r < nums.length) {
			sum += nums[r];
			//stop increment r when sum >= s
			//then work on l
			while (l <= r && sum >= s) {
				sum -= nums[l];
				int len = r - l + 1;
				minLength = Math.min(minLength, len);
				l++;
			}

			r++;
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;

	}

	public static void main(String[] args) {
		int [] nums = new int [] {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, nums));
	}

}
