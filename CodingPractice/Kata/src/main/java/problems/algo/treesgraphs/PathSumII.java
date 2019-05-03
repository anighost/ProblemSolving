package problems.algo.treesgraphs;
/*
 * https://leetcode.com/problems/path-sum-ii/
 */

//Accepted Solution
import java.util.ArrayList;
import java.util.List;

import problems.algo.utils.TreeNode;

public class PathSumII {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<Integer>();
        traverse(root, list, sum);
        return result;
    }
    
    private void traverse(TreeNode node, List<Integer> list, int sum) {
    	
    	//check null node
    	if(node == null) {
    		return;
    	}
    	
    	list.add(node.val);
    	sum -= node.val;
    	//check leaf node
    	if(node.left == null && node.right == null) {
    		if(list != null && !list.isEmpty() && sum == 0) {
    			result.add(new ArrayList<Integer>(list));
    		}
    	}
    	
    	//left recursion
    	traverse(node.left, list, sum);
    	//right recursion
    	traverse(node.right, list, sum);
    	list.remove(list.size()-1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
