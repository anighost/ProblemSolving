package problems.algo.treesgraphs;

import java.util.LinkedList;
import java.util.List;

import problems.algo.utils.TreeNode;

/*
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii/
 */
public class ClosestBSTValueII {

	LinkedList<Integer> res = new LinkedList<>();

	public List<Integer> closestKValues(TreeNode root, double target, int k) {

		//base
		if(root == null) {
			return res;
		}		
		//left
		closestKValues(root.left, target, k);
		//logic
		//if list has less than k elements, add curr element
		if(res.size() < k) {
			res.addLast(root.val);
		} else {
			//check if first element is further from the target than the node element

			if(Math.abs(target - res.getFirst()) > Math.abs(root.val - target)) {
				res.removeFirst();
				res.addLast(root.val);
			} else {
				return res;
			}
		}
		//right
		closestKValues(root.right, target, k);

		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
