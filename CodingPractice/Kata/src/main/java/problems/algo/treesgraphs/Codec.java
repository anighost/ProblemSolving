package problems.algo.treesgraphs;

import java.util.Arrays;
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


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root,sb);
        return sb.toString();
    }
    
    private void dfsSerialize(TreeNode node, StringBuilder s) {
        
        //base
        if (node == null) {
            s.append("X,");
        } else {
            //val
            s.append(node.val+",");
            //left
            dfsSerialize(node.left,s);
            //right
            dfsSerialize(node.right,s);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] charArr = data.split(",");
        List<String> chList = Arrays.asList(charArr);
        return recurDS(chList);
    }
    
    private TreeNode recurDS(List<String> chList) {
        String s = chList.get(0);
        chList.remove(0);	
        if(s.equals("X")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = recurDS(chList);
        node.right = recurDS(chList);
        
        return node;
    }
    
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

		String data = c.serialize(root);
		System.out.println(data);
		TreeNode root1 = c.deserialize(data);
		System.out.println(root1.toString());
		


	}

}
