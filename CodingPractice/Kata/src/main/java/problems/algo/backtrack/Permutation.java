package problems.algo.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Given a collection of distinct integers, return all possible permutations.

	Example:
	
	Input: [1,2,3]
	Output:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]

 *
 */
public class Permutation {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> permute(int[] nums) {
    	
    	List<List<Integer>> outList = new ArrayList<List<Integer>>();
    	int len = nums.length;
    	
    	List<Integer> numsList = new ArrayList<Integer>();
    	
    	for (int i = 0; i < nums.length; i++) {
    		numsList.add(nums[i]);
    	}
    	
    	recurSwap(0, len, numsList, outList);
    	return outList;
        
    }

    public List<List<Integer>> permuteVisited(int[] nums) {
    	
    	boolean [] visited = new boolean[nums.length];
    	recurPermuteVisited(nums, new ArrayList<Integer>(), result, visited);
    	return result;
        
    }
    
    private void recurSwap(int first, int len, List<Integer> numsList, List<List<Integer>> outList) {
    	
    	if (first == len)
    		outList.add(new ArrayList<Integer>(numsList));
    	
    	for (int i = first; i < len; i++) {
    		//Swap first with i
    		Collections.swap(numsList, first, i);
    		//Call recursive function
    		recurSwap(first+1, len, numsList, outList);
    		//backtrack
    		Collections.swap(numsList, first, i);
    	}
    }
    
    private void recurPermuteVisited(int[] nums, List<Integer> permuteList, 
    		List<List<Integer>>  result, boolean [] visited) {
    	
    	//break
    	if (permuteList.size() == nums.length) {
    		result.add(new ArrayList<Integer>(permuteList));
    	}
    	
    	//check each num in nums
    	for (int i = 0; i < nums.length; i++) {
    		if (visited[i]) continue;
    		//mark visited
    		visited[i] = true;
    		permuteList.add(nums[i]);
    		//call recursion
    		recurPermuteVisited(nums, permuteList, result, visited);
    		//backtrack
    		visited[i] = false;
    		permuteList.remove(permuteList.size() - 1);
    	}
    }

	public static void main(String[] args) {

		Permutation p = new Permutation();
		int [] nums = new int[] {1,2,3};
		System.out.println(p.permute(nums));
		System.out.println(p.permuteVisited(nums));

	}

}
