package problems.algo.treesgraphs;

import problems.algo.utils.TreeNode;

/*
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 */
public class ClosestBSTValue {

	int closesNode = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
    	
    	int min = root.val;
    	
    	while (root != null) {
    		if(Math.abs(root.val - target) < Math.abs(min - target)) {
    			min = root.val;
    		}
    		root = root.val > target ? root.left : root.right;
    	}
        
    	return min;
    }
    
	public static void main(String[] args) {

	}

}
