package problems.algo.treesgraphs;

import problems.algo.utils.TreeNode;

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
