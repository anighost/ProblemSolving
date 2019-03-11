package problems.algo.array;

public class RotatedSortedArray {
    public static int search(int[] nums, int target) {
        //1. nums[l] <= nums[mid] --> left side is sorted. do a binary search on left side if target < nums[mid]
        //2.if nums[mid] < nums[r] -- > right side is sorted. binary search on rihght side if target > nums[mid]
        
        if (nums.length == 0) {
            return -1;
        }
        
        int l = 0;
        int r = nums.length - 1;

        return binarySearh(l,r,target,nums);
    }    
    
    public static int binarySearh(int l, int r, int target, int[] nums) {

        if(r < l) {
            return -1;
        }
        int mid = l + (r -l)/2;

        if (target == nums[mid]) {
            return mid;
        }

        if(nums[l] <= nums[mid]) {
            //binary search
            if(nums[l] <= target && target < nums[mid]) {
                return binarySearh(l,mid,target,nums);
            } else {
                return binarySearh(mid+1,r,target,nums);
            }

        } else if (nums[r] > nums[mid]) {
            //binary search
            if(nums[mid] < target && target <= nums[r]) {
                return binarySearh(mid,r,target,nums);
            } else {
                return binarySearh(l,mid-1,target,nums);
            }
        }

        return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] nums = new int[] {-1, 0, 1, 2, -1, -4};
		int [] nums = new int[] {1};
		search(nums, 0);
		System.out.println(search(nums, 0));
		
		
		String s= "AAAA[123 -0400]BBBB";
		String tsStr = s.substring(s.indexOf('[')+1, s.indexOf(']'));
		String tzDelim = " -";
		
		System.out.println(tsStr.substring(0,tsStr.indexOf(tzDelim)));;
		
	}

}
