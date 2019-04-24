package problems.algo.array;

import java.util.Stack;

public class LargestRectangleHistogram {

	public int largestRectangleArea(int[] heights) {
		
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;

		//first dummy element
		stack.push(-1);

		for (int i = 0; i < heights.length; i++) {
			//example: {2,1,5,6,2,3}
			while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
				//pop
				int top = stack.pop();
				//calculate area
                int area = heights[top]*(i - stack.peek() - 1);
				maxArea = Math.max(maxArea, area);
			}
			//push 
			stack.push(i);
		}

		//check remainder of the stack
		while (stack.peek() != -1) {
			int top = stack.pop();
			int dist = heights.length - stack.peek() - 1;
			int area = heights[top] * dist;
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangleHistogram l = new LargestRectangleHistogram();
		
		int[] heights = new int [] {1,1};
		//int[] heights = new int [] {2,1,5,6,2,3};
		System.out.println(l.largestRectangleArea(heights));

	}

}
