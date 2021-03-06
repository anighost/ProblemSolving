package problems.algo.treesgraphs;

import problems.algo.utils.TreeNode;

/*
 * https://leetcode.com/problems/path-sum/
 */
public class BTreePathSum {

	public boolean hasPathSum(TreeNode root, int sum) {

//		if(totalNodeSum(root) == sum) return true;
		return (leafPathSum(root,sum));		
	}
	
	private boolean leafPathSum(TreeNode node, int sum) {
		//recursion break
		if (node == null) return false;
		
		sum -= node.val;
		if(node.left == null && node.right == null) {
			return (sum == 0);
		}
		
		return leafPathSum(node.left, sum) || leafPathSum(node.right, sum);
	}

	//Total Node Sum : Not needed here
	private int totalNodeSum(TreeNode node) {

		//recursion break
		if (node == null) return 0;
		int leftSum = totalNodeSum(node.left);
		int rightSum = totalNodeSum(node.right);

		int sum = node.val + leftSum + rightSum;
		System.out.println("Node : "+node.val + " Sum : "+sum);
		return (node.val + leftSum + rightSum);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTreePathSum bt = new BTreePathSum();
		
		TreeNode root = new TreeNode(5);
		//left side
		TreeNode l = new TreeNode(4);
		TreeNode ll = new TreeNode(11);
		TreeNode lll = new TreeNode(7);
		TreeNode llr = new TreeNode(2);
		ll.left = lll;
		ll.right = llr;
		l.left = ll;
		root.left = l;
		
		//right side
		

		TreeNode r = new TreeNode(4);
		root.left = l;
		root.right = r;
		
		System.out.println(bt.hasPathSum(root, 14));

	}

}
