package problems.algo.array;
/**
 * 
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

	Your algorithm's runtime complexity must be in the order of O(log n).

	If the target is not found in the array, return [-1, -1].
	
	Example 1:
	
	Input: nums = [5,7,7,8,8,10], target = 8
	Output: [3,4]
	Example 2:
	
	Input: nums = [5,7,7,8,8,10], target = 6
	Output: [-1,-1]
 *
 */
public class FindFirstNLastSortedArr {

    public int[] searchRange(int[] nums, int target) {
        
        int [] outArr = new int[2];
        outArr[0] = getFirst(nums, target, 0, nums.length-1);
        outArr[1] = getLast(nums, target, 0, nums.length-1);
        
        return outArr;
    }
    
    int getFirst(int [] nums, int target, int l , int r) {
        
        int mid = (l+r)/2;
        
        if (r >= l) {
            if((mid == 0 || nums[mid - 1] < target ) && (nums[mid] == target)) {
                return mid;
            } else if (nums[mid] < target) {
                return getFirst(nums,target,mid+1,r);
            } else {
                return getFirst(nums,target,l,mid-1);
            }
        }
        
        return -1;
    }
    
    int getLast(int[] nums, int target, int l , int r) {
        int mid = (l+r)/2;
        
        if (r >= l) {
            if((mid == nums.length - 1 || nums[mid + 1] > target ) && (nums[mid] == target)) {
                return mid;
            } else if (nums[mid] > target) {
                return getLast(nums,target,l,mid-1);
                
            } else {
                return getLast(nums,target,mid+1,r);
            }
        }
        
        return -1;
    }    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFirstNLastSortedArr f = new FindFirstNLastSortedArr();
		
		int [] a1 = new int[] {5,7,7,8,8,10};
		int [] o1 = f.searchRange(a1, 8);
		
		for (int i = 0; i<o1.length; i++) {
			System.out.println("element "+i + " : "+o1[i]);
		}

	}

}
