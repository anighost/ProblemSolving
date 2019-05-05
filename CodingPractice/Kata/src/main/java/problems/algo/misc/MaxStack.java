package problems.algo.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import problems.algo.utils.DoubleLinkedList;
import problems.algo.utils.Node;

/**
 * https://leetcode.com/problems/max-stack/
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
public class MaxStack {

	DoubleLinkedList dll;
	TreeMap<Integer, List<Node>> map;
	

	public MaxStack() {
		dll = new DoubleLinkedList();
		map = new TreeMap<Integer, List<Node>>();
	}

	public void push(int x) {
		
		//add to dll
		Node node = dll.add(x);
		//add to map
		if(!map.containsKey(x) ) {
			map.put(x,new ArrayList<Node>());
		} 
		map.get(x).add(node);
	}

	public int pop() {
		int pop = dll.pop();
		//remove from map
		List<Node> list = map.get(pop);
		list.remove(list.size()-1);
		if(list.isEmpty()) {
			map.remove(pop);
		}
		return pop;
	}

	public int top() {
		return dll.peek();
	}

	public int peekMax() {
		return map.lastKey();
	}

	public int popMax() {
		int lastKey = map.lastKey();
		//remove from map
		List<Node> list = map.get(lastKey);
		Node node = list.remove(list.size()-1);
		if(list.isEmpty()) {
			map.remove(lastKey);
		}
		//remove from dll
		dll.unlink(node);

		return lastKey;
	}

	public static void main(String[] args) {
		MaxStack theStack = new MaxStack(); 
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
