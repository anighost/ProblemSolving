package problems.algo.recursion;

import java.util.List;

import problems.algo.utils.NestedInteger;

/*
 * https://leetcode.com/problems/nested-list-weight-sum-ii/
 */
public class NestedListWeightSum implements NestedInteger{

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getMaxDepth(nestedList);
        return depthSum(nestedList, maxDepth);
    }
    
    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                sum += depth * i.getInteger();
            } else {
                sum += depthSum(i.getList(), depth-1);
            }
        }
        
        return sum;
    }
    
    private int getMaxDepth(List<NestedInteger> nestedList) {
        int maxDepth = 0;
        
        for (NestedInteger i : nestedList) {
            if (!i.isInteger()) {
                maxDepth = Math.max(getMaxDepth(i.getList()),maxDepth);
            }
        }
        
        return 1 + maxDepth;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isInteger() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer getInteger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInteger(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(NestedInteger ni) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NestedInteger> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
