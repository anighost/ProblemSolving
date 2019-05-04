package problems.algo.treesgraphs;

/*
 * https://leetcode.com/problems/invert-binary-tree/
 */
import problems.algo.utils.TreeNode;

public class MirrorBinaryTree {


	public static TreeNode mirrorTree(TreeNode node) {

		return recurMirror(node);

	}

	private static TreeNode recurMirror(TreeNode node) {

		//break recursion
		if(node == null) return node;

		//call recursion on left
		TreeNode l = recurMirror(node.left);
		//call recursion on right
		TreeNode r = recurMirror(node.right);

		//swap
		node.left = r;
		node.right = l;

		return node;
	}
	
	//Also check if a BT is mirror image of another
	public static boolean checkIfImage(TreeNode n1, TreeNode n2) {
		
		//check root
		if(n1 == null && n2 == null) return true;
		if(n1 == null || n2 == null) return false;

		return (n1.val == n2.val && checkIfImage(n1.left, n2.right) && checkIfImage(n1.right, n2.left));
	}
	
	//Check if a BT is symmetric
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    
    private boolean isMirror(TreeNode n1, TreeNode n2) {
        
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        
        return (n1.val == n2.val) && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
        
    } 


//	void inOrder(TreeNode root) 
//	{ 
//		inOrder(root); 
//	} 
//
	/* Helper function to test mirror(). Given a binary 
       search tree, print out its data elements in 
       increasing sorted order.*/
	void inOrder(TreeNode node) 
	{ 
		if (node == null) {
			return; 
		}

		inOrder(node.left); 
		System.out.print(node.val + " "); 

		inOrder(node.right); 
	} 

	public static void main(String[] args) {
        /* creating a binary tree and entering the nodes */
		MirrorBinaryTree tree = new MirrorBinaryTree(); 
		TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
  
        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :"); 
        tree.inOrder(root); 
        System.out.println(""); 
        TreeNode mirrorTree = mirrorTree(root);
        tree.inOrder(mirrorTree);
        /*
         * 		1               1
         * 		/\              /\
         * 	   2  3            3  2
         * 	  /\	              /\
         *   4  5                5  4
         *  
         */
        
        System.out.println();
		TreeNode n1 = new TreeNode(1); 
		n1.left = new TreeNode(2); 
		n1.right = new TreeNode(3); 
		n1.left.left = new TreeNode(4); 
		n1.left.right = new TreeNode(5); 

        TreeNode n2 = new TreeNode(1); 
        n2.left = new TreeNode(3); 
        n2.right = new TreeNode(2); 
        n2.right.left = new TreeNode(5); 
        n2.right.right = new TreeNode(4); 

        System.out.println(checkIfImage(n1, mirrorTree));
        System.out.println(checkIfImage(n1, n2));

	}

}
