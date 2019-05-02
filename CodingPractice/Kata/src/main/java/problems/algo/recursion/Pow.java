package problems.algo.recursion;

public class Pow {

	public double myPow(double x, int n) {

		if(n < 0) {
			n = -n;
			x = 1/x;
		}

		return halfPow(x,n);
	}

	public double halfPow(double x, int n) {

		if (n == 0) {
			return 1.0d;
		}

		double h = halfPow(x, n/2);

		if(n%2 == 0) {
			return h*h;
		} else {
			return h * h * x;
		}
	}
	public static void main(String[] args) {
		Pow p = new Pow();
		System.out.println(p.myPow(3.0d, 5));

	}

}
