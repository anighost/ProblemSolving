package problems.algo.recursion;

public class ReverseInt {

	static int reverse(int x) {
		int m = 0;

		while (x != 0) {
			int mod = x % 10;
			x = x / 10;

			//Check for overflow
			//Integer.MIN_VALUE = -2147483648
			//Integer.MAX_VALUE = 2147483647
			// m*10 + mod > MAX_VALUE || m*10 + mod < Integer.MIN_VALUE

			if (m > (Integer.MAX_VALUE/10 - mod/10)  || m < (Integer.MIN_VALUE/10 - mod/10)) {
				System.out.println(m);
				return 0;
			}

			m = m * 10 + mod;

		}

		return m;	
	}



	public static void main(String[] args) {
		//System.out.println(reverse(-123));
		System.out.println(reverse(1463847412));
	}

}
