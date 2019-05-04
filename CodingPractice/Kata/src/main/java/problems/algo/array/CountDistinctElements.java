package problems.algo.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given an array with duplicate elements give an algorithm to get the count of distinct elements in the array.
 */
public class CountDistinctElements {
	
	public static int countDistinct(int [] nums) {
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		
		return set.size();
	}
	
	public static int countDistinctInLine(int [] nums) {
		int ans = 0;
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			
			while (i < nums.length - 1 && nums[i] == nums[i+1]) {
				i++;
			}
			ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int [] a1 = new int [] {10, 20, 20, 10, 30, 10};
		System.out.println(countDistinct(a1));
		System.out.println(countDistinctInLine(a1));
	}

}
