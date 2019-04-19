package problems.algo.linkedlist;

public class DoubleLinkedList {
	
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

	DoubleNode head;
	
	public void insertAtHead (int val) {
		
		DoubleNode n1 = new DoubleNode(val);
		DoubleNode tmp = head;
		head = n1;
		
		n1.next = tmp;
		tmp.prev = n1;
		
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

}
