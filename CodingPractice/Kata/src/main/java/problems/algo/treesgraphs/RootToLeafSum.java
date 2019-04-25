package problems.algo.treesgraphs;

/*
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
import java.util.ArrayList;
import java.util.List;

public class RootToLeafSum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	List<Integer> list = new ArrayList<Integer>();

	public int sumNumbers(TreeNode root) {

		int sum = 0;
		if (root != null) {
			traverse(root,"");
			for (int i : list) {
				sum += i;
			}
		}

		return sum;
	}

	private void traverse(TreeNode node, String s) {

		//break
		if (node == null) {
			return;
		}
		s+= String.valueOf(node.val);
		//leaf node
		if(node.left == null && node.right == null) {
			//add to list
			list.add(Integer.parseInt(s));
		}

		traverse(node.left,s);
		traverse(node.right,s);

	}
	public static void main(String[] args) {
		RootToLeafSum cl = new RootToLeafSum();
		TreeNode root = cl.new TreeNode(1);
		
		TreeNode l = cl.new TreeNode(2);
		TreeNode r = cl.new TreeNode(3);
		root.left = l;
		root.right = r;
		
		System.out.println(cl.sumNumbers(root));
	}

}
