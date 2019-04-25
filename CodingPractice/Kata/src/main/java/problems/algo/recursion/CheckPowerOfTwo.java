package problems.algo.recursion;

public class CheckPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        
    	if (n == 1) return true;
    	if (n < 1) return false;
    	
    	if ( n % 2 != 0) {
    		return false;
    	}
    	int x = n/2;
    	return isPowerOfTwo(x);
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckPowerOfTwo c = new CheckPowerOfTwo();
		System.out.println(c.isPowerOfTwo(16));
		System.out.println(c.isPowerOfTwo(1));
		System.out.println(c.isPowerOfTwo(15));
		System.out.println(c.isPowerOfTwo(0));

	}

}
