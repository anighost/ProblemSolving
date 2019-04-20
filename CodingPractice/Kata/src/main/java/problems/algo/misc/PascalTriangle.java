package problems.algo.misc;

import java.util.ArrayList;
/*
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * Example:

	Input: 5
	Output:
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	[1,5,10,10,5,1]
	]
	
	//	i -> index of list
	//	j -> index of int inside ith List
	//	1. f(i,j) = f(i-1, j-1) + f(i-1, j)
	//	2. if j = 0 || j == i => 1
	 
 */
import java.util.List;

public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> outList = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				list.add(recurGen(i,j));
			}
			
			outList.add(list);
		}
		
		return outList;

	}
	
	public int recurGen(int i, int j) {
		
		if (j == 0 || j == i) {
			return 1;
		} 
		
		return recurGen(i-1, j-1) + recurGen(i-1, j);
		
	}
	
	public List<List<Integer>> generateDP(int numRows) {

		List<List<Integer>> outList = new ArrayList<List<Integer>>();
		if(numRows <= 0) {
			return outList;
		}
		outList.add(new ArrayList<Integer>());
		outList.get(0).add(1);
		
		for (int i = 1; i < numRows; i++) {
			List<Integer> curRow = new ArrayList<Integer>();
			List<Integer> prevRow = outList.get(i-1);
			
			for(int j = 0; j<= i; j++) {
				if(j == 0 || j == i) {
					curRow.add(1);
				} else {
					curRow.add(prevRow.get(j-1) + prevRow.get(j));
				}
			}
			
			outList.add(curRow);
			
		}
		
		return outList;

	}
	
	public static void main(String[] args) {
		
		PascalTriangle p = new PascalTriangle();
		System.out.println(p.generate(5));
		System.out.println(p.generateDP(5));

	}

}
