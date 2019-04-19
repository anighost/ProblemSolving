package problems.algo.search;

public class FindSquareRoot {
	
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        return recurHelper(x,1,x);
    }    
    
    public static int recurHelper(int x, int start, int end) {
        
        if(start <= end) {
            int mid = (start+end)/2;
            
            if(mid * mid == x) {
                return mid;
            }
            
            if(mid > x/mid) {
                return recurHelper(x,start,mid-1);
            } else {
                if((mid+1) > x/(mid+1)) {
                    return mid;
                }

                return recurHelper(x,mid+1,end);
            }
        }

        return -1;
    }

    public static int findSqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        int r = x;
        while (r > x/r)
            r = (r + x/r) / 2;
        return (int) r;

    }    

    public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(mySqrt(8));
//		System.out.println(Integer.MAX_VALUE);
		System.out.println(mySqrt(2147395599));
		System.out.println(findSqrt(6));
		System.out.println(findSqrt(9));
		System.out.println(findSqrt(2147395599));
	}

}
