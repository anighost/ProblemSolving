package problems.algo.array;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SockPair {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {

		//ar => [1,2,1,2,1,3,2]
		//2 pairs
		//int pairCounter = 0;

		//1. Create hashmap => color, count
		//2. Loop through ar and check in map
		//  2.1 if present, increment the count
		//  2.2 if not, put
		//3. Iterate through map and check if value%2 == 0? If yes, increment pairCounter;


		//Create hashmap
		Map<Integer, Integer> pairMap = new HashMap<Integer, Integer>();

		//loop
		for (int i = 0; i < ar.length ; i++) {
			int count = 1;
			if (pairMap.get(ar[i]) != null) {
				count = pairMap.get(ar[i]) + 1;
			} 
			pairMap.put(ar[i], count);                    
		}

		int pairCounter = 0;
		for (Entry<Integer, Integer> mapEntry : pairMap.entrySet()) {
			int counter = mapEntry.getValue();
			int numPairs = (counter/2);
			pairCounter = pairCounter + numPairs;
		}

		return pairCounter;

	}


	public static void main(String[] args) throws IOException {
		int [] ar = {10, 20 ,20 ,10 ,10 ,30 ,50 ,10 ,20};
		int n = 9;

		int result = sockMerchant(n, ar);
		System.out.println("Output : "+result);

	}
}
