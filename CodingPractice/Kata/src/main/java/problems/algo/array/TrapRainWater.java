package problems.algo.array;

import java.util.Stack;

/**
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.


	The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
	In this case, 6 units of rain water (blue section) are being trapped.

	Example:

	Input: [0,1,0,2,1,0,1,3,2,1,2,1]
	Output: 6

 *
 */
public class TrapRainWater {

	public static int trap(int[] height) {
		int result = 0;
		Stack<Integer> rainStack = new Stack<Integer>();
		int curr = 0;
		
		while (curr < height.length) {
			
			while (!rainStack.isEmpty() && height[curr] > height[rainStack.peek()]) {
				int top = rainStack.pop();
				
				//empty check
				if (rainStack.isEmpty()) {
					break;
				}
				
				int distance = curr - rainStack.peek() -1;
				int boundHeight = Math.min(height[curr], height[rainStack.peek()]) - height[top]; 
				
				result += distance*boundHeight;
				
			}
			rainStack.push(curr++);
			
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] height = new int [] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}

}
