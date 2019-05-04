package problems.algo.search;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }
    
    public int findDuplicateAlt(int[] nums) {
        
        int tortoise = 0;
        int hare = 0 ;
        
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        
        int ptr1 = 0;
        int ptr2 = tortoise;
        
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        
        return ptr1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a1 = new int [] {1,3,4,2,2};
		System.out.println(findDuplicate(a1));
		
		int [] a2 = new int [] {3,1,3,4,2};
		System.out.println(findDuplicate(a2));
		
	}
}
