package problems.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> outSet = new HashSet<>();
        int len = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < len -2 ;  i++) {
            
            int l = i+1;
            int r = len - 1;
            int targetSum = 0 - nums[i];
            
            while ( l < r) {
                
                if(nums[l] + nums[r] == targetSum) {
                    //add to output list
                	List<Integer> subList = Arrays.asList(nums[i], nums[l], nums[r]);
                    outSet.add(subList);
                    l++;r--;
                } else {
                    if(nums[l] + nums[r] < targetSum ){
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        
        return new ArrayList<List<Integer>>(outSet);
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] nums = new int[] {-1, 0, 1, 2, -1, -4};
		int [] nums = new int[] {-2,0,-1,1,1,-1,2};
		List<List<Integer>> outlist = threeSum(nums);
		System.out.println(outlist);
	}

}
