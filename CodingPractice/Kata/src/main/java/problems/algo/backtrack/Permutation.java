package problems.algo.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
    public List<List<Integer>> permute(int[] nums) {
    	
    	Set<List<Integer>> outSet = new HashSet<>();
    	int len = nums.length;
    	
    	List<Integer> numsList = new ArrayList<Integer>();
    	
    	for (int i = 0; i < nums.length; i++) {
    		numsList.add(nums[i]);
    	}
    	
    	recurSwap(0, len, numsList, outSet);
    	return new ArrayList<>(outSet);
        
    }
    
    void recurSwap(int first, int len, List<Integer> numsList, Set<List<Integer>> outSet) {
    	
    	if (first == len)
    		outSet.add(new ArrayList<Integer>(numsList));
    	
    	for (int i = first; i < len; i++) {
    		
    		Collections.swap(numsList, first, i);
    		recurSwap(first+1, len, numsList, outSet);
    		Collections.swap(numsList, first, i);

    	}
    	
    	
    }

	public static void main(String[] args) {

		Permutation p = new Permutation();
		int [] nums = new int[] {1,2,3};
		System.out.println(p.permute(nums));

	}

}
