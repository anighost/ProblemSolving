package problems.algo.treesgraphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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


public class Codec2 {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		//return dfsSerialize(root, "");
		dfsSerializeOptimized(root, sb);
		
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		final String delim = ",";

		if(data == null || data.isEmpty()) {
			return null;
		}

		String[] chArr = data.split(delim);
		List<String> chList = new LinkedList<String>(Arrays.asList(chArr));

		//return recurConstructTree(chList);
		return recurConstructTreeOptimized(chList);
	}


	//DFS Pre Order - Serialize
	public String dfsSerialize(TreeNode node, String str) {

		//break recursion
		if(node == null) {
			str += "X,";
		} else {
			//append value to string
			str += node.val+",";
			//recursion
			//left 
			str = dfsSerialize(node.left,str);
			//right
			str = dfsSerialize(node.right,str);
		}

		return str;
	}

	public void dfsSerializeOptimized(TreeNode node, StringBuilder sb) {

		//break recursion
		if(node == null) {
			sb.append("X,");
		} else {
			//append value to string
			sb.append(node.val+",");
			//check if leaf node
			if(node.left == null && node.right == null) {
				sb.append("',");
			} else {
				//recursion
				//left 
				dfsSerializeOptimized(node.left,sb);
				//right
				dfsSerializeOptimized(node.right,sb);
			}
		}

//		return sb;
	}

	//Deserialize
	public TreeNode recurConstructTree(List<String> chList) {
		String nullStr = "X";
		//Value of node
		String val = chList.get(0);
		chList.remove(0);
		//null check - null node
		//recursion break
		if (nullStr.equals(val)) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.parseInt(val));

		//call with node.left
		node.left = recurConstructTree(chList);
		//call with node.right
		node.right = recurConstructTree(chList);

		return node;

	}

	public TreeNode recurConstructTreeOptimized(List<String> chList) {
		String nullStr = "X";
		String leafChar = "'";
		//Value of node
		String val = chList.get(0);
		chList.remove(0);
		//null check - null node
		//recursion break
		if (nullStr.equals(val)) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.parseInt(val));

		//check for leaf
		if (chList.get(0).equals(leafChar)) {
			node.left = null;
			node.right = null;
			chList.remove(0);
		} else {
			//call with node.left
			node.left = recurConstructTreeOptimized(chList);
			//call with node.right
			node.right = recurConstructTreeOptimized(chList);
		}

		return node;

	}
	//	public String bfsSerialize(TreeNode root, String str) {
	//
	//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Codec2 c = new Codec2();
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		root.left = left1;
		root.right = right1;

		TreeNode left2 = new TreeNode(4);
		TreeNode right2 = new TreeNode(5);
		root.right.left = left2;
		root.right.right = right2;

		String str = c.serialize(root);
		System.out.println(str);

		TreeNode node = c.deserialize(str);
		System.out.println(node.toString());


	}

}
