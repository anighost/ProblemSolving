package problems.algo.array;

import java.util.ArrayList;

/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

	Example:

	Input: [10,9,2,5,3,7,101,18]
	Output: 4 
	Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
	Note:

	There may be more than one LIS combination, it is only necessary for you to return the length.
	Your algorithm should run in O(n2) complexity.
	Follow up: Could you improve it to O(n log n) time complexity?

 */

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {

		if(nums==null || nums.length==0)
			return 0;

		ArrayList<Integer> list = new ArrayList<Integer>(); 

		for(int num: nums){
			if(list.size()==0 || num>list.get(list.size()-1)){
				list.add(num);
			} else{
				int i=0; 
				int j=list.size()-1;

				while(i<j){
					int mid = (i+j)/2;
					if(list.get(mid) < num){
						i=mid+1;
					}else{
						j=mid;
					}
				}

				list.set(j, num);
			}
		}

		return list.size();    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		int [] arr = new int [] {10,9,2,5,3,7,101,18};
		System.out.println(l.lengthOfLIS(arr));

	}

}
