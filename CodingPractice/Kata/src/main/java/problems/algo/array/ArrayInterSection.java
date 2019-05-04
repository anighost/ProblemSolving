package problems.algo.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import problems.algo.utils.CommonUtils;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 * Given two arrays, write a function to compute their intersection.

	Example 1:
	
	Input: nums1 = [1,2,2,1], nums2 = [2,2]
	Output: [2,2]
	Example 2:
	
	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	Output: [4,9]
	Note:
	
	Each element in the result should appear as many times as it shows in both arrays.
	The result can be in any order.
	Follow up:
	
	What if the given array is already sorted? How would you optimize your algorithm?
	What if nums1's size is small compared to nums2's size? Which algorithm is better?
	What if elements of nums2 are stored on disk, and the memory is limited such that 
	you cannot load all elements into the memory at once?

 *
 */
public class ArrayInterSection {
    
	public static int[] intersect1(int[] nums1, int[] nums2) {
		
        Set<Integer> res = new HashSet<Integer>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        int [] out = new int [res.size()];
        int k = 0;
        for (int num : res) {
            out[k++] = num;
        }
        return out;
    }

	public static int[] intersect2(int[] nums1, int[] nums2) {
		
        Set<Integer> res = new HashSet<Integer>();
        Set<Integer> set1 = new HashSet<Integer>();
        
        for (int i = 0; i < nums1.length; i++) {
        	set1.add(nums1[i]);
        }
        
        for (int j = 0; j < nums2.length; j++) {
        	if(set1.contains(nums2[j])) {
        		res.add(nums2[j]);
        	}
        }
        
        int [] out = new int [res.size()];
        int k = 0;
        for (int num : res) {
            out[k++] = num;
        }
        return out;
    }

	
	public static void main(String[] args) {
		int [] nums11 = new int [] {1,2,2,1};
		int [] nums12 = new int [] {2,2};

		CommonUtils.printArray(intersect1(nums11, nums12));;
		CommonUtils.printArray(intersect2(nums11, nums12));;

		int [] nums21 = new int [] {4,9,5};
		int [] nums22 = new int [] {9,4,9,8,4};

		CommonUtils.printArray(intersect1(nums21, nums22));;
		CommonUtils.printArray(intersect2(nums21, nums22));;
		
	}
}
