package problems.algo.search;

/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinRotatedSortedArray2 {

    public int findMin(int[] nums) {
        return binarySearch(nums, 0 , nums.length - 1);
    }
    
    private int binarySearch(int [] nums, int l, int r) {

        while (l < r ) {
        	int mid = (l+r)/2;
        	if (nums[mid] > nums[r]) {
        		l = mid + 1;
        	} else if (nums[mid] < nums[r]){
        		r = mid;
        	} else {
        		r--;
        	}
            
        }  
        
        return nums[l];
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
