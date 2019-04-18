package problems.algo.array;

/**
 * 
 * Sort the squares of elements of a sorted array 
 *
 */
public class SquareSortedArray {

	public static int[] squareArray(int [] nums) {

		int k = 0;
		for (k = 0; k <nums.length; k++) {
			if(nums[k] > 0) {
				break;
			}
		}

		//k = index of first positive number or end of array in case all are negative
		int [] merged = new int[nums.length];

		//merge nums[0-(k-1)] and nums[k - (len-1)]
		int i = k-1, j = k;
		int index = 0;

		while(i >= 0 && j < nums.length) {

			if (nums[i] * nums[i] < nums[j] * nums[j]) {
				merged[index++] = nums[i] * nums[i];
				i--;
			} else {
				merged[index++] = nums[j] * nums[j];
				j++;
			}
		}

		while(i >= 0) {
			merged[index++] = nums[i] * nums[i];
			i--;
		}

		while(j < nums.length) {
			merged[index++] = nums[j] * nums[j];
			j++;
		}

		return merged;
	}

	public static void main(String[] args) {
		int [] nums = {-6, -3, -1, 2, 4, 5};
		int [] nums2 = {-6, -3, -1};
		int [] outNums = squareArray(nums);
		for (int i = 0; i < outNums.length; i++) {
			System.out.print(outNums[i]+" ");
		}
		System.out.println();

		int [] outNums2 = squareArray(nums2);
		for (int i = 0; i < outNums2.length; i++) {
			System.out.print(outNums2[i]+" ");
		}
	}

}
