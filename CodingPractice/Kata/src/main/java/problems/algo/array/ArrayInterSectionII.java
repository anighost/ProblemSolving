package problems.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import problems.algo.utils.CommonUtils;

/*
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class ArrayInterSectionII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer>();
        
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
	public static void main(String[] args) {
		int [] nums11 = new int [] {1,2,2,1};
		int [] nums12 = new int [] {2,2};

		CommonUtils.printArray(intersect(nums11, nums12));;

	}

}
