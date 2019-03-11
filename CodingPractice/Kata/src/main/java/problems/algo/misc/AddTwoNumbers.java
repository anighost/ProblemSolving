package problems.algo.misc;
/**
 * 
 * 	You are given two non-empty linked lists representing two non-negative integers. 
 * 	The digits are stored in reverse order and each of their nodes contain a single digit. 
 * 	Add the two numbers and return it as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.

	Example:

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.

 *
 */
public class AddTwoNumbers {
	/**
	 * Definition for singly-linked list.
	 * struct ListNode {
	 *     int val;
	 *     ListNode *next;
	 *     ListNode(int x) : val(x), next(NULL) {}
	 * };
	 */

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummy;
        int carry = 0;
        
        while (p != null && q != null) {
        	
        	int x = (p != null ? p.val : 0);
        	int y = (q != null ? q.val : 0);
        	int sum = (x + y + carry) ;
        	
        	carry = sum/10;
        	
        	curr.next = new ListNode(sum % 10);
        	curr = curr.next;
        	
        	if (p != null) {
        		p = p.next;
        	}
        	
        	if (q != null) {
        		q = q.next;
        	}
        }
        
        if (carry > 0) {
        	curr.next = new ListNode(carry);
        }

    	return dummy.next;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      String Str = new String("bb");

	      System.out.print("Return Value :" );
	      System.out.println(Str.substring(0, 1) );
	      System.out.println(1001/1000);
	      

	}

}
