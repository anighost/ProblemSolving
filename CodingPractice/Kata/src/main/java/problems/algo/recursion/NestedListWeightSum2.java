package problems.algo.recursion;

import java.util.List;

import problems.algo.utils.NestedInteger;

/*
 * https://leetcode.com/problems/nested-list-weight-sum/
 */
public class NestedListWeightSum2 implements NestedInteger{

    public int depthSum(List<NestedInteger> nestedList) {
        return recurSum(nestedList,1);
    }
    
    private int recurSum(List<NestedInteger> nestedList, int depth) {
        //base - if nestedList is Empty
        int sum = 0;
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                sum += depth * i.getInteger();
            } else {
                sum += recurSum(i.getList(), depth+1);
            }
        }
        
        return sum;
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
