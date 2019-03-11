package problems.algo.array;

public class ArrayMedian {
	/**
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
		Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
		You may assume nums1 and nums2 cannot be both empty.
		
		Example 1:
		
		nums1 = [1, 3]
		nums2 = [2]
		
		The median is 2.0
		Example 2:
		
		nums1 = [1, 2]
		nums2 = [3, 4]
		
		The median is (2 + 3)/2 = 2.5

	 */
	
	private static double getMedian(int [] nums1, int [] nums2) {
		double median = 0.0d;
		
		//Logic
		int mergedLength = nums1.length + nums2.length;
		int [] mergedArray = new int[mergedLength];
		int i = 0;
		int j = 0;
		int k = 0;
		
		//Merge Arrays
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				mergedArray[k++] = nums1[i++]; 
			} else {
				mergedArray[k++] = nums2[j++]; 				
			}
		}
		
		while (i < nums1.length) {
			mergedArray[k++] = nums1[i++]; 			
		}
		
		while (j < nums2.length) {
			mergedArray[k++] = nums2[j++]; 				
		}
		
		//Get Median
		int midPoint = mergedArray.length/2;
		if (mergedArray.length%2 == 0 ) {
			median = (double) (mergedArray[midPoint-1] + mergedArray[midPoint])/2;
		} else {
			median = (double) mergedArray[midPoint];
		}
		
		return median;
	}
	
	//Main
	public static void main(String [] args) {
		
		int [] nums11 = {1, 3};
		int [] nums12 = {2};
		System.out.println("Case 1 : Median : " + getMedian(nums11, nums12));
		
		int [] nums21 = {1, 2};
		int [] nums22 = {3, 4};
		System.out.println("Case 2 : Median : " + getMedian(nums21, nums22));
		
	}

}
