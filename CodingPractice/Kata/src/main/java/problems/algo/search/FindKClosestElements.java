package problems.algo.search;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-k-closest-elements/
 * 
 * 	Example 1:
	Input: [1,2,3,4,5], k=4, x=3
	Output: [1,2,3,4]
	Example 2:
	Input: [1,2,3,4,5], k=4, x=-1
	Output: [1,2,3,4]
	Note:
	The value k is positive and will always be smaller than the length of the sorted array.
	Length of the given array is positive and will not exceed 104
	Absolute value of elements in the array and x will not exceed 104

 */

public class FindKClosestElements {

	//Linear Solution
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < arr.length; i++) {
            if(res.size() < k) {
                //keep adding to result as long as we don't have k elements in res
                res.add(arr[i]);
            } else {
                //check distance of arr[i] from x and distance of res.get(0) from x
                // if arr[i] is closer to x, remove res.get(0) and add arr[i] at the end of res
                
                if(Math.abs(x - res.get(0)) > Math.abs(arr[i] - x)) {
                    res.remove(0);
                    res.add(arr[i]);
                }
            }
        }
     
        return res;
    }

    //Binary Search Solution
    public List<Integer> findClosestElementsBinSearch(int[] arr, int k, int x) {
        int start = 0, end = arr.length-k;
        
        while(start<end) {
            int mid = (start + end)/2;
            if (Math.abs(x - arr[mid]) > Math.abs(arr[mid+k]-x))
                start = mid + 1;
            else
                end = mid;
        }

        List<Integer> results = new ArrayList<Integer>();
        for(int i=start;i<start+k;i++){
            results.add(arr[i]);
        }
        return results;  
        
    }

    public static void main(String[] args) {

    	FindKClosestElements cl = new FindKClosestElements();
    	int [] a1 = new int [] {1,2,3,4,5};
    	System.out.println(cl.findClosestElements(a1, 4, 3));
    	System.out.println(cl.findClosestElementsBinSearch(a1, 4, 3));
	}

}
