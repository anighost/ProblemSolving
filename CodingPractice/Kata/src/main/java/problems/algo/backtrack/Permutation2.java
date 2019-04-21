package problems.algo.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.

	Example:
	
	Input: [1,1,2]
	Output:
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]

 *
 */
public class Permutation2 {
	
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> outSet = new HashSet<List<Integer>>();
		List<Integer> numList = new ArrayList<Integer>();
		int len = nums.length;
		for(int i =0; i<len; i++)
			numList.add(nums[i]);
		
		recurPermute(0, len, numList, outSet);
		
        return new ArrayList<List<Integer>>(outSet);
    }
	
	private void recurPermute(int first, int len, List<Integer> numList, Set<List<Integer>> outSet) {
		
		if(first == len) {
			outSet.add(new ArrayList<Integer>(numList));
		}
		
		for(int i = first; i <len; i++) {
			Collections.swap(numList, first, i);
			recurPermute(first+1, len, numList, outSet);
			Collections.swap(numList, first, i);
		}
	}

    public List<List<Integer>> permuteUniqueVisited(int[] nums) {
    	
    	boolean [] visited = new boolean[nums.length];
    	recurPermuteUniqueVisited(nums, new ArrayList<Integer>(), result, visited);
    	return result;
        
    }
    
    private void recurPermuteUniqueVisited(int[] nums, List<Integer> permuteList, 
    		List<List<Integer>>  result, boolean [] visited) {
    	
    	//break
    	if (permuteList.size() == nums.length) {
    		result.add(new ArrayList<Integer>(permuteList));
    		return;
    	}
    	
    	//check each num in nums
    	for (int i = 0; i < nums.length; i++) {
    		if (visited[i]) continue;
    		
    		//eliminate duplicate
            if (i > 0 && visited[i - 1] && nums[i] == nums[i - 1]) 
            	continue;

    		//mark visited
    		visited[i] = true;
    		permuteList.add(nums[i]);
    		//call recursion
    		recurPermuteUniqueVisited(nums, permuteList, result, visited);
    		//backtrack
    		visited[i] = false;
    		permuteList.remove(permuteList.size() - 1);
    	}
    }
	
	public static void main(String[] args) {
		
		Permutation2 p = new Permutation2();
		
		int [] nums = new int [] {1,1,2};
		System.out.println(p.permuteUnique(nums));
		System.out.println(p.permuteUniqueVisited(nums));
	}

}
