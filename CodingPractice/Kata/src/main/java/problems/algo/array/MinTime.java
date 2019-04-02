package problems.algo.array;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinTime {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	static int minimumTime(int numOfSubFiles, List<Integer> files)
	{
		// WRITE YOUR CODE HERE
		// Create a priority queue 
		PriorityQueue<Integer> pq = 
				new PriorityQueue<Integer>(); 

		// Adding items to the pQueue 
		for(int i=0;i<numOfSubFiles;i++) 
		{ 
			pq.add(files.get(i)); 
		} 

		// Initialize result 
		int res = 0; 

		// While size of priority queue  
		// is more than 1 
		while (pq.size() > 1) 
		{ 
			// Extract shortest two ropes from pq 
			int first = pq.poll(); 
			int second = pq.poll(); 

			// Connect the ropes: update result 
			// and insert the new rope to pq 
			res += first + second; 
			pq.add(first + second); 
		} 

		return res;    
	}
	// METHOD SIGNATURE ENDS
	
	public static void main(String [] args) {
		
		List<Integer> list = Arrays.asList(20,4,8,2); 
	    int size = list.size(); 
	    
	    System.out.println(minimumTime(size, list));
	}

}
