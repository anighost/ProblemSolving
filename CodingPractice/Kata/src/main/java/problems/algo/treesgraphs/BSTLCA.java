package problems.algo.treesgraphs;

import problems.algo.utils.TreeNode;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class BSTLCA {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
