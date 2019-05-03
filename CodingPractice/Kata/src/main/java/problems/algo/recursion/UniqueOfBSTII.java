package problems.algo.recursion;

import java.util.ArrayList;
import java.util.List;

import problems.algo.utils.TreeNode;

/*
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueOfBSTII {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
          return new ArrayList<TreeNode>();
        }
        return recurGen(1, n);        
    }
    
    private List<TreeNode> recurGen(int l, int r) {
        List<TreeNode> allTrees = new ArrayList<TreeNode>();
        //base
        if(l>r) {
            allTrees.add(null);
            return allTrees;
        }
        
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftTrees = recurGen(l,i-1);
            List<TreeNode> rightTrees = recurGen(i+1,r);
            
            for (TreeNode lt :  leftTrees) {
                for (TreeNode rt : rightTrees) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = lt;
                    curr.right = rt;
                    
                    allTrees.add(curr);
                }
            }
        }
        
        return allTrees;
    }
    
}
