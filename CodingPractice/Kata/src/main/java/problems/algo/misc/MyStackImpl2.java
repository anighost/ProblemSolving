package problems.algo.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * Design a max stack that supports push, pop, top, peekMax and popMax.

	push(x) -- Push element x onto stack.
	pop() -- Remove the element on top of the stack and return it.
	top() -- Get the element on the top.
	peekMax() -- Retrieve the maximum element in the stack.
	popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
	Example 1:

	MaxStack stack = new MaxStack();
	stack.push(5); 
	stack.push(1);
	stack.push(5);
	stack.top(); -> 5
	stack.popMax(); -> 5
	stack.top(); -> 1
	stack.peekMax(); -> 5
	stack.pop(); -> 1
	stack.top(); -> 5
	Note:

	-1e7 <= x <= 1e7
	Number of operations won't exceed 10000.
	The last four operations won't be called when stack is empty.

 *
 */
public class MyStackImpl2 {

	List<Integer> maxStack;
	Map<Integer, List<Integer>> map; 

	public MyStackImpl2() {
		maxStack = new ArrayList<Integer>();
		map = new TreeMap<Integer, List<Integer>>();
	}

	public void push(int x) {
		maxStack.add(x);
		//Modify the map
		List<Integer> list = map.get(x);;
		if(map.get(x) == null){
			list = new ArrayList<Integer>();
			map.put(x,list);
		}
		
		list.add(maxStack.size()-1);
	}

	public int pop() {
		int num = maxStack.get(maxStack.size()-1);
		maxStack.remove(maxStack.size()-1);
		
		List<Integer> list = map.get(num);
		list.remove(list.size() - 1);
		if(list.isEmpty()) {
			map.remove(num);
		}
		
		return num;
	}

	public int top() {
		return maxStack.get(maxStack.size()-1);
	}

	public int peekMax() {
		//Optimize Further
		int maxNum = Integer.MIN_VALUE;
		for (int i = 0; i < maxStack.size(); i++) {
			if(maxNum <= maxStack.get(i)) {
				maxNum = maxStack.get(i);
			}
		}

		return maxNum;

	}

	public int popMax() {
		//Optimize Further
		int pos = 0;
		int maxNum = Integer.MIN_VALUE;

		for (int i = 0; i < maxStack.size(); i++) {
			if(maxNum <= maxStack.get(i)) {
				maxNum = maxStack.get(i);
				pos = i;
			}
		}

		maxStack.remove(pos);

		return maxNum;
	}

	public static void main(String[] args) {
		MyStackImpl2 theStack = new MyStackImpl2(); 
		theStack.push(-2);
		System.out.println(theStack.popMax());
		theStack.push(-45);
		theStack.push(-82);
		theStack.push(-29);
		System.out.println(theStack.pop());
		System.out.println(theStack.peekMax());
		theStack.push(40);
		System.out.println(theStack.pop());
		System.out.println(theStack.pop());
		theStack.push(66);
		System.out.println(theStack.peekMax());
		System.out.println(theStack.peekMax());
		theStack.push(-61);
		System.out.println(theStack.peekMax());
		theStack.push(98);
		System.out.println(theStack.peekMax());

	}

}
