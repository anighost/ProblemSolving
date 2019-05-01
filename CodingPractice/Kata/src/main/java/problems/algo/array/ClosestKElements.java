package problems.algo.array;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-k-closest-elements/
 */
public class ClosestKElements {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		
        int start = 0, end = arr.length-k;
        
        while(start<end) {
            int mid = (start + end)/2;
            System.out.println((x - arr[mid]) + " : "+(arr[mid+k]-x)); //DEBUG
            if (x - arr[mid] > arr[mid+k]-x)
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
		ClosestKElements c = new ClosestKElements();

//		int [] arr1 = new int [] {1,2,3,4,5};
//		System.out.println(c.findClosestElements(arr1, 4, 3));
				
		int [] arr2 = new int [] {1,3,4,5,6,9,100,1000};
		System.out.println(c.findClosestElements(arr2, 3, 6));
	}

}
