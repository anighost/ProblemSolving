package problems.algo.array;

public class Fibonacci {
	
	static void getFibonacci(int n) {
		int [] arr = new int [n];
		for (int i = 0; i < n; i++) {
			if (i <= 1 ) {
				arr[i] = 1;
			} else {
				arr[i] = arr[i-1] + arr[i-2];
			}
			
			System.out.print(" "+arr[i]);
		}
	}
	
	static void getFibonacciWOArr(int n) {
		int n1 = 1;
		int n2 = 1;
		int currNum = 1;
		int i = 0;
		while (i < n) {
			if (i > 1 ) {
				currNum = n1 + n2;
				n1 = n2;
				n2 = currNum;
			}
			System.out.print(" "+currNum);
			i++;
		}
		
	}
	
	static int recFib(int n) {
		if(n <= 1) {
			return 1;
		}
		return recFib(n - 1) + recFib(n - 2);
	}
	
	public static void main (String [] args) {
		getFibonacci(10);
		System.out.println();
		getFibonacciWOArr(10);
		System.out.println();
		System.out.println(recFib(10));
	}

}
