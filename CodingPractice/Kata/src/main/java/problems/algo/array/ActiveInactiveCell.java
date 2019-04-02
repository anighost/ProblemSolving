package problems.algo.array;

import java.util.ArrayList;
import java.util.List;

public class ActiveInactiveCell {

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<Integer> cellCompete(int[] states, int days)
	{
		// WRITE YOUR CODE HERE
		List<Integer> cellList = new ArrayList<Integer>();
		int n = states.length;
		int[] temp = new int [n];

		for (int i = 0; i <n ; i++) {
			temp[i] = states[i];
		}

		while (days-- > 0 ) {

			//first and last cell
			temp[0] = 0 ^ temp[1];
			temp[n-1] = 0 ^ temp[n-2];
			
			for (int i = 1; i < n-1 ; i++) {
				temp[i] = temp[i-1] ^ temp[i+1]; 
			}

			for (int i = 0; i <n ; i++) {
				states[i] = temp[i];
			}
		}
		
		for (int i = 0; i <n ; i++) {
			cellList.add(states[i]);
		}
		return cellList;
	}
	// METHOD SIGNATURE ENDS


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
