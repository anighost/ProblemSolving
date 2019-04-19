package problems.algo.array;

public class RightRotation {

	public static void rotate(int[] nums, int k) {

		k %= nums.length;

		reverse(nums,0,nums.length-1);
		reverse(nums,0,k-1);
		reverse(nums,k,nums.length-1);

	}

	public static void reverse(int [] nums, int start, int end) {

		int i = start;
		int j = end;

		while (i < j ) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp; 
			i++;
			j--;
		}        
	}

	public static void main(String[] args) {
		
		int[] nums = new int [] {1,2,3,4,5,6,7,8,9,10};
		rotate(nums, 3);
		System.out.println();
		//Output: [8,9,10,1,2,3,4,5,6,7]
		//step:
		//1. 10,9,8,7,6,5,4,3,2,1
		//2. 8,9,10,7,6,5,4,3,2,1
		//3. 8,9,10,1,2,3,4,5,6,7
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();

		int[] nums1 = new int [] {1,2};
		rotate(nums1, 3);
		System.out.println();
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i]+" ");
		}
		System.out.println();

	}

}
