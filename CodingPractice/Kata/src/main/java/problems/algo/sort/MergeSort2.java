package problems.algo.sort;

import java.util.Arrays;

public class MergeSort2 {
	
	public void mergeSort(int [] a, int start, int end) {
		
		//divide
		int mid = (start+end)/2;
		
		if (start < end) {
			//recursion for left
			mergeSort(a, start, mid);
			//recursion for right
			mergeSort(a, mid+1, end);
			//merge
			merge(a, start, mid, end);
		}
	}
	
	public void merge(int [] a, int start, int mid, int end) {
		//left -> start - mid
		//right -> mid+1 - end
		
		//merge
		int i = start; int j = mid + 1;
		int [] tmp = new int [end - start + 1];
		int k = 0;
		while ( i <= mid && j <= end) {
			if (a[i] < a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}
		
		while (i <= mid) {
			tmp[k++] = a[i++];
		}
		
		while (j <= end) {
			tmp[k++] = a[j++];
		}
		
		//copy to original array
		for (int x = start; x <= end; x++) {
			a[x] = tmp[x - start];
		}
	}

	public static void main(String[] args) {
	    int[] actual = { 5, 1, 6, 2, 3, 4 };
	    int[] expected = { 1, 2, 3, 4, 5, 6 };
	    
	    MergeSort2 m = new MergeSort2();
	    m.mergeSort(actual, 0, actual.length-1);
	    
	    for (int i = 0; i < actual.length; i++) {
	    	System.out.print(actual[i]+" | ");
	    }
	    System.out.println();
	    for (int i = 0; i< expected.length; i++) {
	    	System.out.print(expected[i]+" | ");
	    }

	    System.out.println();
	    
	    System.out.println("is actual equals to expected : " + 
                Arrays.equals(actual, expected)); 
	}

}
