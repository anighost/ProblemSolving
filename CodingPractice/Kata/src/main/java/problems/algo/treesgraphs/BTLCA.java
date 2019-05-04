package problems.algo.treesgraphs;

import problems.algo.utils.TreeNode;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class BTLCA {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurFind(root,p,q);
        return ans;
    }
    
    private boolean recurFind(TreeNode root, TreeNode n1, TreeNode n2) {
        //base
         if (root == null) return false; 
        
        //check value
        int curr_check = (root == n1 || root == n2) ? 1 : 0;
        //left
        int left_check = recurFind(root.left, n1, n2) ? 1 : 0;
        //right
        int right_check = recurFind(root.right, n1, n2) ? 1 : 0;
        
        int total_check = curr_check + left_check + right_check;
        if (total_check >= 2) {
            ans = root;
        }
        
        return total_check > 0 ;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
