package problems.algo.linkedlist;

/**
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

	Example:

	Input:
	[
	  1->4->5,
	  1->3->4,
	  2->6
	]
	Output: 1->1->2->3->4->4->5->6

 *
 */

public class MergeKSortedLinkedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	//Linear Iteration
	public ListNode mergeKListsLinear(ListNode[] lists) {

		if (lists.length == 0) {
			return null;
		}
		ListNode merged = lists[0];
		for (int i = 1; i < lists.length; i++) {
			merged = mergeTwo(merged,lists[i]);
		}

		return merged;

	}

	//Divide n Conquer
	public ListNode mergeKListsOptimized(ListNode[] lists) {

		int len = lists.length;
		int interval = 1;

		while (interval < len) {
			int i = 0;
			while (i < len - interval) {
				lists[i] = mergeTwo(lists[i], lists[i+interval]);
				i = i + interval * 2;
			}

			interval *= 2;
		}

        return (len > 0 ? lists[0] : null);

	}


	ListNode mergeTwo(ListNode l1, ListNode l2) {

		ListNode head = new ListNode(0);
		ListNode curr = head;

		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}

			curr = curr.next;
		}

		while (l1 != null) {
			curr.next = l1;
			l1 = l1.next;
			curr = curr.next;
		}

		while (l2 != null) {
			curr.next = l2;
			l2 = l2.next;
			curr = curr.next;
		}

		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] list = new ListNode[3];
		MergeKSortedLinkedList m = new MergeKSortedLinkedList();
		m.new ListNode(1);
		ListNode l1 = m.new ListNode(1);		
		l1.next = m.new ListNode(4);
		l1.next.next = m.new ListNode(5);

		ListNode l2 = m.new ListNode(1);
		l2.next = m.new ListNode(3);
		l2.next.next = m.new ListNode(4);

		ListNode l3 = m.new ListNode(2);
		l3.next = m.new ListNode(6);

		list[0] = l1;
		list[1] = l2;
		list[2] = l3;


//		ListNode outNode = m.mergeKListsLinear(list);
		ListNode outNodeOptimized = m.mergeKListsOptimized(list);

//		ListNode p = outNode;
//		while (p != null) {
//			System.out.print(p.val+"->");
//			p = p.next;
//		}

		ListNode q = outNodeOptimized;
		while (q != null) {
			if (q.next != null) {
				System.out.print(q.val+" -> ");
			} else {
				System.out.print(q.val);				
			}
			q = q.next;
		}
		
//		int [] a = null ;
//		a[0] = 1;

	}

}
