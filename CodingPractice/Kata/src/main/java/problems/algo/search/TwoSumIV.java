package problems.algo.search;

import java.util.HashSet;
import java.util.Set;

import problems.algo.utils.TreeNode;

/*
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */

public class TwoSumIV {
	
    public boolean findTarget(TreeNode root, int k) {
    	Set<Integer> set = new HashSet<Integer>();
    	return dfs(root, k, set);
    }

    private boolean dfs(TreeNode node, int k, Set<Integer> set) {
    	if (node == null) return false;
    	if (set.contains(k - node.val)) return true;
    	set.add(node.val);
    	return dfs(node.left, k, set) || dfs(node.right,k,set);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
