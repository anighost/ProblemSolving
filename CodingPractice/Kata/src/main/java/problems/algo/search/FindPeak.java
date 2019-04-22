package problems.algo.search;
/*
 * 	A peak element is an element that is greater than its neighbors.

	Given an input array nums, where nums[i] != nums[i+1], find a peak element and return its index.
	
	The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
	
	You may imagine that nums[-1] = nums[n] = -infinity.
 */

public class FindPeak {
    
	//O(n) solution - can you improve?
	public static int findPeakElement(int[] nums) {
		int idxPeak = -1;
		int peakVal = Integer.MIN_VALUE;
		
		if (nums.length == 1) return 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= peakVal) {
				idxPeak = i;
				peakVal = nums[i];
			} else {
				return idxPeak;
			}
		}
        
		return idxPeak;
    }

	public static int findPeakElementOptimized(int[] nums) {
		
		int start = 0, end = nums.length-1;
		
		while (start < end) {
			int mid = start + (end - start)/2;
			
			//check mid with mid+1
			if(nums[mid] < nums[mid+1]) {
				//peak is on the right
				start = mid + 1;
			} else {
				//peak is on the left
				end = mid;
			}
		}
		
        
		return start;
    }

	public static void main(String[] args) {
		
//		int [] nums = new int [] {1,2,1,3,5,6,4};
//		System.out.println(findPeakElement(nums));

		int [] nums1 = new int [] {1,2};
		System.out.println(findPeakElement(nums1));
		System.out.println(findPeakElementOptimized(nums1));
		
	}
}
