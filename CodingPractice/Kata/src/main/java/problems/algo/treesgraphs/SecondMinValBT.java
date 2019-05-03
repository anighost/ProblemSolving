package problems.algo.treesgraphs;

import problems.algo.utils.TreeNode;

/*
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */

public class SecondMinValBT {

	int min1;
	int ans = Integer.MAX_VALUE;
	
    public int findSecondMinimumValue(TreeNode root) {
    	min1 = 0;
    	dfs(root);
    	return ans < Integer.MAX_VALUE? ans : -1;
    }
    
    private void dfs(TreeNode node) {
    	
    	if (node != null) {
    		if (min1 < node.val && node.val < ans) {
    			ans = node.val;
    		} else if(node.val == min1) {
    			dfs(node.left);
    			dfs(node.right);
    		}
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
