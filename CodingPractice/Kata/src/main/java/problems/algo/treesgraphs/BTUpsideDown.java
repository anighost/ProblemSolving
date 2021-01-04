package problems.algo.treesgraphs;

import problems.algo.utils.TreeNode;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
Given the root of a binary tree, turn the tree upside down and return the new root.

You can turn a binary tree upside down with the following steps:

The original left child becomes the new root.
The original root becomes the new right child.
The original right child becomes the new left child.


The mentioned steps are done level by level, it is guaranteed that every node in the given tree has either 0 or 2 children.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: [4,5,2,null,null,3,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of nodes in the tree will be in the range [0, 10].
1 <= Node.val <= 10
Every node has either 0 or 2 children.

*/
public class BTUpsideDown {
	
	public static TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = root.left, right = root.right;
		if (left != null) {
			TreeNode ret = upsideDownBinaryTree(left);
			left.left = right;
			left.right = root;
			root.left = null;
			root.right = null;
			return ret;
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		TreeNode l = new TreeNode(4);
		TreeNode r = new TreeNode(5);
		root.left = l;
		root.right = r;
		
		System.out.println(upsideDownBinaryTree(root));
	}

}
