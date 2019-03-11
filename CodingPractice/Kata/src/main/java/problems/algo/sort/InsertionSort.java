package problems.algo.sort;

public class InsertionSort {
	
	static void insertionSort(int [] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			int j = i-1;
			int k = i;
			while( j >= 0) {
				if (arr[k] < arr[j]) {
					//swap
					int num = arr[j];
					arr[j] = arr[k];
					arr[k] = num;
				}
				//decrement j and k
				j--;k--;
				
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] inArr = new int[] {25,17,31,13,2}; 
		insertionSort(inArr);
		for (int i = 0; i <inArr.length; i++) {
			System.out.println(inArr[i]);
		}

	}

}
