package problems.algo.treesgraphs;

import java.util.ArrayList;
import java.util.List;

import problems.algo.utils.TreeNode;

/*
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.

	Example:

	Input: [1,2,3,null,5,null,4]
	Output: [1, 3, 4]
	Explanation:

	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---
 */

public class BTRightView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		traverse(root,results,0);
		return results;
	}

	private void traverse(TreeNode node, List<Integer> results, int depth) {

		//break
		if (node != null) {
			//add node to results
			if(results.size() == depth) {
				results.add(node.val);
			}

			//recursiion call
			//right
			traverse(node.right, results, depth+1);
			//left
			traverse(node.left, results, depth+1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
