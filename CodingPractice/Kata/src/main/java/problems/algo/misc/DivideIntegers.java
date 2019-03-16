package problems.algo.misc;

/**
 * 
 * 	Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

	Return the quotient after dividing dividend by divisor.
	
	The integer division should truncate toward zero.
	
	Example 1:
	
	Input: dividend = 10, divisor = 3
	Output: 3
	
	Example 2:
	
	Input: dividend = 7, divisor = -3
	Output: -2
	Note:
	
	Both dividend and divisor will be 32-bit signed integers.
	The divisor will never be 0.
	Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [-2^31,  2^31 - 1]. 
	For the purpose of this problem, assume that your function returns 2^31 - 1 when the division result overflows.
 *
 */
public class DivideIntegers {

    public static int divide(int dividend, int divisor) {
    	
    	if (dividend >= Integer.MAX_VALUE && divisor == 1) {
    		return Integer.MAX_VALUE;
    	}
    	
    	if (dividend == Integer.MIN_VALUE && divisor == 1) {
    		return Integer.MIN_VALUE;
    	}

    	if(divisor >= Integer.MAX_VALUE || divisor <= Integer.MIN_VALUE || dividend <= Integer.MIN_VALUE) {
    		return Integer.MAX_VALUE;
    	}

    	int x = Math.abs(dividend);
    	int y = Math.abs(divisor);
    	int sign = 1;
    	
    	if((dividend < 0 && divisor > 0)|| (divisor < 0 && dividend > 0)) {
    		sign = -1;
    	}
    	
    	if (y == 0) {
    		throw new IllegalArgumentException("Division by zero");
    	}
    	
    	if (x == y) {
    		return sign * 1;    		
    	}
    	
    	if (x < y) {
    		return 0;    		
    	}

        return sign * iterativeSub(x, y);
    }
    
    //recursion does not work for large problems
    static int subtract(int x, int y) {
    	
    	if (x == 0) {
    		return 0;
    	} else if(x < y) {
    		return 0;
    	} else if (x == y) {
    		return 1;
    	} else {
    		return 1+subtract(x-y,y);
    	}
    }
    
    static int iterativeSub(int x, int y) {
    	int div = 0;
    	while (x > y) {
    		div++;
    		x = x - y;
    	}
    	
    	return div;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483648,-1));
		
		
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
		
		

	}

}
