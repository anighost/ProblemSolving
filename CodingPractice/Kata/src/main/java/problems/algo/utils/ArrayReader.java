package problems.algo.utils;

public class ArrayReader {
	public int[] nums;

	public ArrayReader(int[] nums) {
		super();
		this.nums = nums;
	}

	
	public int get(int k) {
		if (k >= nums.length || k < 0) return Integer.MAX_VALUE;
		return this.nums[k];
	}

}
