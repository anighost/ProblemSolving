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
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> outSet = new HashSet<List<Integer>>();
		List<Integer> numList = new ArrayList<Integer>();
		int len = nums.length;
		for(int i =0; i<len; i++)
			numList.add(nums[i]);
		
		recurPermute(0, len, numList, outSet);
		
        return new ArrayList<List<Integer>>(outSet);
    }
	
	void recurPermute(int first, int len, List<Integer> numList, Set<List<Integer>> outSet) {
		
		if(first == len) {
			outSet.add(new ArrayList<Integer>(numList));
		}
		
		for(int i = first; i <len; i++) {
			Collections.swap(numList, first, i);
			recurPermute(first+1, len, numList, outSet);
			Collections.swap(numList, first, i);
		}
	}

	public static void main(String[] args) {
		
		Permutation2 p = new Permutation2();
		
		int [] nums = new int [] {1,1,2};
		System.out.println(p.permuteUnique(nums));
	}

}
