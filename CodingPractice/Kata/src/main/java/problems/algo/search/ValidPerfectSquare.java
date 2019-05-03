package problems.algo.search;
/*
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

	public boolean isPerfectSquare(int num) {
		int l = 1;
		int r = num;
		
		while(l <= r) {
			
			int mid = l + (r -l)/2;
			
			if (mid * mid == num) return true;
			if(mid > num/mid) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
