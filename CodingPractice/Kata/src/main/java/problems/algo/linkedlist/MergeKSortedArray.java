package problems.algo.linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedArray {

	public class ArrayContainer implements Comparable<ArrayContainer>{
		int[] arr;
		int index;
		
		public ArrayContainer(int[] arr, int index) {
			this.arr = arr;
			this.index = index;
		}
		
		@Override
		public int compareTo(ArrayContainer o) {
			return this.arr[index] - o.arr[o.index];
		}
	}
	
	public int[] mergeKSortedArray(int[][] arr) {
		PriorityQueue<ArrayContainer> pq = new PriorityQueue<ArrayContainer>();
		int total = 0;
		for(int[] a : arr) {
			pq.add(new ArrayContainer(a, 0));
			total = total+ a.length;
		}
		
		int[] result = new int[total];
		
		int k = 0;
		while (!pq.isEmpty()) {
			
			ArrayContainer ac = pq.poll();
			result[k++] = ac.arr[ac.index];
			
			if(ac.index < ac.arr.length) {
				pq.add(new ArrayContainer(ac.arr, ac.index+1));
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
