package problems.algo.treesgraphs;

import problems.algo.utils.TreeNode;

/**
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
 *
 */


public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {		
		return dfsSerialize(root, "");
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		TreeNode node = null;


		return node;
	}

	//DFS Pre Order
	public String dfsSerialize(TreeNode root, String str) {
		// Recursive serialization.
		if (root == null) {
			str += "X,";
		} else {
			str += root.val + ",";
			if (root.left == null && root.right == null) {
				str += "'";				
			} else {
				str = dfsSerialize(root.left, str);
				str = dfsSerialize(root.right, str);
			}
		}
		return str;
	}

//	public String bfsSerialize(TreeNode root, String str) {
//
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Codec c = new Codec();
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		root.left = left1;
		root.right = right1;

		TreeNode left2 = new TreeNode(4);
		TreeNode right2 = new TreeNode(5);
		root.right.left = left2;
		root.right.right = right2;

		System.out.println(c.serialize(root));


	}

}
