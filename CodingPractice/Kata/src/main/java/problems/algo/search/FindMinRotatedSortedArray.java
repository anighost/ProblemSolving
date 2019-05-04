package problems.algo.search;

/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinRotatedSortedArray {

    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length -1 );
    }
    
    private int binarySearch(int [] nums, int l, int r) {

    	if (nums[r] > nums[l]) return nums[0];

        while (l < r ) {
            
            int mid = (l+r)/2;
            
            if (nums[mid] > nums[mid+1]) return nums[mid+1];
            if (nums[mid-1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[l]) {
                //left side is sorted. search on right side
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }  
        
        return nums[l];
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
