package problems.algo.linkedlist;

import problems.algo.utils.ListNode;

/*
 * Reverse a singly linked list.

	Example:

	Input: 1->2->3->4->5->NULL
	Output: 5->4->3->2->1->NULL
	Follow up:

	A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		
		ListNode curr = head;
		ListNode prev = null;
		
		while(curr != null) {
			
			ListNode tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
			
		}
		
		return prev;
		
	}
	
	public ListNode reverseListRecur(ListNode head) {
		
		if (head == null| head.next == null) {
			return head;			
		}
		
		ListNode nextNode = reverseListRecur(head.next);
		head.next.next = head;
		head.next = null;
		
		return nextNode;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		head.next = l1;
		ListNode l2 = new ListNode(3);
		l1.next = l2;
		ListNode l3 = new ListNode(4);
		l2.next = l3;
		ListNode l4 = new ListNode(5);
		l3.next = l4;
		System.out.println(head);
		
//		System.out.println(r.reverseList(head));
		System.out.println(r.reverseListRecur(head));

	}

}
