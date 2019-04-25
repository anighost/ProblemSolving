package problems.algo.recursion;

public class CheckIfPower {

    public boolean isSquare(int n) {
        return recurPower(n, 0, n);
    }
    
    private boolean recurPower(int n, int start, int end) {
        
    	int mid = start + (end - start)/2;
        //break
    	if (mid * mid == n) {
    		return true;
    	}
    	if(start < end) {
            //left side
            if (mid * mid > n) {
                return recurPower(n, start, mid - 1);
            } else {
            	return recurPower(n, mid+1, end);
            }
    	}
    	
    	return false;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckIfPower c = new CheckIfPower();
		System.out.println(c.isSquare(9));

	}

}
