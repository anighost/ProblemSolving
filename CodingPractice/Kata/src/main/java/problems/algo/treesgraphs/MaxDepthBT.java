package problems.algo.treesgraphs;

import problems.algo.utils.TreeNode;

/*
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthBT {

    public int maxDepth(TreeNode root) {
    	return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
