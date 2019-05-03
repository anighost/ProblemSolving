package problems.algo.treesgraphs;

import java.util.ArrayList;
import java.util.List;

import problems.algo.utils.TreeNode;

public class BSTTargetSum {

	public boolean findTarget(TreeNode root, int k) {
		List<Integer> treeList = new ArrayList<Integer>();
		treeList = treeToList(root,treeList);
		return findHelper(treeList,k);
	}

	private boolean findHelper(List<Integer> list, int k) {
		int i = 0;
		int j = list.size() -1 ;

		while (i < j) {
			if (list.get(i) + list.get(j) == k)
				return true;
			if (list.get(i) + list.get(j) < k) {
				i++;
			} else {
				j--;
			}
		}

		return false;
	}

	private List<Integer> treeToList(TreeNode node, List<Integer>  list) {
		//break
		if ( node == null) {
			return list;
		}
		//left
		treeToList(node.left, list);
		//add
		list.add(node.val);
		//right
		treeToList(node.right, list);
		return list;
	}

	//Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
