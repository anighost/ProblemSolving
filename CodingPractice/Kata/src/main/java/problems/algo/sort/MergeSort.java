package problems.algo.sort;

import java.util.Arrays;

public class MergeSort {
	
	static void merge(int [] a, int start, int mid, int end) {
		int i = start; int j = mid+1; int k=0;
		int[] temp = new int[end - start + 1];
		
		while(i <= mid && j <= end) {
			
			if(a[i] <= a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		
		//remaining first half
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		
		//remaining 2nd half
		while (j <= end) {
			temp[k++] = a[j++];
		}
		
		for (int m = start; m <= end ; m++) {
			a[m] = temp[m - start];
		}
		
	}
	
	static void mergeSort(int [] arr, int start , int end) {
		if (start < end) {
			int mid = (end + start)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}

	public static void main(String[] args) {
	    int[] actual = { 5, 1, 6, 2, 3, 4 };
	    int[] expected = { 1, 2, 3, 4, 5, 6 };
	    MergeSort.mergeSort(actual, 0, actual.length - 1);
	    
	    System.out.println("is actual equals to expected : " + 
                Arrays.equals(actual, expected)); 
	}

}
