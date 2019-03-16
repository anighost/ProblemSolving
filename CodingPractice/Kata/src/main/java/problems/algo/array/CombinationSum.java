package problems.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.

	The same repeated number may be chosen from candidates unlimited number of times.
	
	Note:
	
	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.
	Example 1:
	
	Input: candidates = [2,3,6,7], target = 7,
	A solution set is:
	[
	  [7],
	  [2,2,3]
	]
	Example 2:
	
	Input: candidates = [2,3,5], target = 8,
	A solution set is:
	[
	  [2,2,2,2],
	  [2,3,3],
	  [3,5]
	]
 *
 */
public class CombinationSum {
	public List<List<Integer>> outList = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<Integer> tempList = new ArrayList<Integer>();
    	searchTarget(candidates, 0, 0, target, tempList);
    	return outList;
        
    }
    
    void searchTarget(int[] nums, int pos, int sum, int target, List<Integer> tempList) {
    	
    	if(sum > target) {
    		return;
    	}
    	
    	if(sum == target) {
    		outList.add(new ArrayList<>(tempList));
    		return;
    	}
    	
    	for (int i = pos; i < nums.length; i++) {
    		
    		if(target - sum < nums[i]) {
        		return;
    		}
    		
    		tempList.add(nums[i]);
    		searchTarget(nums, i, sum + nums[i], target, tempList);
    		if (!tempList.isEmpty()) {
        		tempList.remove(tempList.size() - 1);
    		}
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {2,3,6,7};
		CombinationSum combSum = new CombinationSum();
		List<List<Integer>> outList = combSum.combinationSum(nums, 7);
		System.out.println(outList);

	}

}
