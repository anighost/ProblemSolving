package problems.algo.array;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

	Note: The solution set must not contain duplicate subsets.
	
	Example:
	
	Input: nums = [1,2,3]
	Output:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 *
 */
public class SubSet {
	
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> outList = new ArrayList<List<Integer>>();
    	
    	Arrays.sort(nums);
    	backTrackSubSet(nums, new ArrayList<Integer>(), 0, outList);
    	
        return outList;
    }
    
    void backTrackSubSet(int [] nums, List<Integer> tmp, int pos, List<List<Integer>> outList) {
    	outList.add(new ArrayList<Integer>(tmp));
    	
    	for(int i = pos; i < nums.length; i++) {
    		tmp.add(nums[i]);
    		backTrackSubSet(nums, tmp, i+1, outList);
    		tmp.remove(tmp.size() - 1);
    	}
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int[] {2,3,1,4};
		SubSet s = new SubSet();
		System.out.println(s.subsets(nums));

	}

}
