package problems.algo.treesgraphs;

public class MirrorBinaryTree {

	TreeNode root; 

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

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

	void inOrder() 
	{ 
		inOrder(root); 
	} 

	/* Helper function to test mirror(). Given a binary 
       search tree, print out its data elements in 
       increasing sorted order.*/
	void inOrder(TreeNode node) 
	{ 
		if (node == null) 
			return; 

		inOrder(node.left); 
		System.out.print(node.val + " "); 

		inOrder(node.right); 
	} 

	public static void main(String[] args) {
        /* creating a binary tree and entering the nodes */
		MirrorBinaryTree tree = new MirrorBinaryTree(); 
        tree.root = tree.new TreeNode(1); 
        tree.root.left = tree.new TreeNode(2); 
        tree.root.right = tree.new TreeNode(3); 
        tree.root.left.left = tree.new TreeNode(4); 
        tree.root.left.right = tree.new TreeNode(5); 
  
        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :"); 
        tree.inOrder(); 
        System.out.println(""); 
        
        tree.inOrder(mirrorTree(tree.root));

	}

}
