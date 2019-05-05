package problems.algo.treesgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import problems.algo.utils.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigZagBT {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;

        int ind = 1; //1 -> left to right , -1 -> right to left
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        List<Integer> list = new ArrayList<Integer>();
        int size = 1;
        
        while (!q.isEmpty()) {
            
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                
                if(ind == 1 ) {
                    list.add(n.val);
                } else {
                    list.add(0,n.val);
                }

                //traverse
                if (n.left != null)  q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
            
            res.add(new ArrayList<Integer>(list));
            list.clear();
            ind = -1 * ind;
            size = q.size();
        }
        
        return res;
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
