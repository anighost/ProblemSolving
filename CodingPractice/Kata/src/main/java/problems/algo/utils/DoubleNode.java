package problems.algo.utils;

public class DoubleNode {

	int val;
	DoubleNode prev;
	DoubleNode next;
	
	
	public DoubleNode(int x) {
		val = x;
	}


	public int getVal() {
		return val;
	}


	public void setVal(int val) {
		this.val = val;
	}


	public DoubleNode getPrev() {
		return prev;
	}


	public void setPrev(DoubleNode prev) {
		this.prev = prev;
	}


	public DoubleNode getNext() {
		return next;
	}


	public void setNext(DoubleNode next) {
		this.next = next;
	}
	
	
}
