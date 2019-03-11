package problems.algo.misc;

public class Play {

	public static void main(String[] args) {
		String s = "MCMXCIV";
		// M -> 0
		// CM -> 1
		// XC -> 3
		// IV -> 5
		
		//1000*1 + 900*1 + 90 + 4
		
		String ss1 = "M";
		String ss2 = "C";
		String ss3 = "X";
		String ss4 = "IV";
		
		System.out.println(s.indexOf(ss1));
		System.out.println(s.indexOf(ss2));
		System.out.println(s.indexOf(ss3));
		System.out.println(s.indexOf(ss4));
		System.out.println(s.indexOf("A"));
	}

}
