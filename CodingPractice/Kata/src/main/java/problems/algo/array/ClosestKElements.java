package problems.algo.array;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-k-closest-elements/
 */
public class ClosestKElements {

	//Efficient
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
	
	//Inefficient
	public List<Integer> findClosestElementsAlt(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<Integer>();
		
		for (int i = 0; i <arr.length; i++) {
			if(res.size() < k) {
				res.add(arr[i]);
			} else {
				//compare the distance of res.get(0) with arr[i] from x
				if(Math.abs(x - res.get(0)) > Math.abs(x-arr[i])) {
					//remove res.get(0) and add arr[i]
					res.remove(0);
					res.add(arr[i]);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ClosestKElements c = new ClosestKElements();

//		int [] arr1 = new int [] {1,2,3,4,5};
//		System.out.println(c.findClosestElements(arr1, 4, 3));
				
		int [] arr2 = new int [] {1,3,4,5,6,9,100,1000};
		System.out.println(c.findClosestElements(arr2, 3, 6));
		System.out.println(c.findClosestElementsAlt(arr2, 3, 6));

		int [] arr3 = new int [] {0,0,0,1,3,5,6,7,8,8};
		System.out.println(c.findClosestElements(arr3, 2, 2));
		System.out.println(c.findClosestElementsAlt(arr3, 2, 2));
	}

}
