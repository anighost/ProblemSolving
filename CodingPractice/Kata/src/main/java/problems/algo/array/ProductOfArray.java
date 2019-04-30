package problems.algo.array;

/*
 * 	https://leetcode.com/problems/product-of-array-except-self/

	Given an array nums of n integers where n > 1,  
	return an array output such that output[i] is equal to the product of all the elements of nums 
	except nums[i].

	Example:

	Input:  [1,2,3,4]
	Output: [24,12,8,6]
	Note: Please solve it without division and in O(n).

	Follow up:
	Could you solve it with constant space complexity? 
	(The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArray {

	public int[] productExceptSelfBrute(int[] nums) {

		int [] res = new int [nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j <nums.length;j++) {
				if(j ==0) res[i] = 1;
				if (i != j) {
					res[i] *= nums[j];
				}
			}
		}

		return res;
	}

	public int[] productExceptSelf(int[] nums) {

		int len = nums.length;
		int[] res = new int[len];
		if(len == 0)
			return res;
		int runningprefix = 1;
		for(int i = 0; i < len; i++){
			res[i] = runningprefix;
			runningprefix*= nums[i];
		}
		int runningsufix = 1;
		for(int i = len -1; i >= 0; i--){
			res[i] *= runningsufix;
			runningsufix *= nums[i];
		}
		return res;
	}

	private void printArray(int [] nums) {
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		ProductOfArray p = new ProductOfArray();
		int[] nums = new int [] {1,2,3,4};
		int[] res1 = p.productExceptSelfBrute(nums);
		p.printArray(res1);
				int[] res2 = p.productExceptSelf(nums);
				p.printArray(res2);

	}

}
