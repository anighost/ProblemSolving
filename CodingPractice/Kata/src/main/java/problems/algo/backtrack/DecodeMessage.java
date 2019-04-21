package problems.algo.backtrack;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/decode-ways/
 * 
 * each alphabet is represented by a number from 1 - 26
 * Example: 
 * 	
 * a - 1
 * b - 2
 * ...
 * z = 26
 * 
 * if you are given an input string(which is a number), 
 * determine how many alphabetic messages it can be decoded to 
 * 
 * Example: input -> "12"
 * Output - 2
 * 
 * 12 -> "ab"
 * 12 -> "l"
 * 
 * Example: input -> "226"
 * output : 3
 * 
 */
public class DecodeMessage {
	
	private static Map<Integer, Character> charMap = new HashMap<Integer, Character>();
	
	static {
		charMap.put(1,'a');
		charMap.put(2,'b');
		charMap.put(3,'c');
		charMap.put(4,'d');
		charMap.put(5,'e');
		charMap.put(6,'f');
		charMap.put(7,'g');
		charMap.put(8,'h');
		charMap.put(9,'i');
		charMap.put(10,'j');
		charMap.put(11,'k');
		charMap.put(12,'l');
		charMap.put(13,'m');
		charMap.put(14,'n');
		charMap.put(15,'o');
		charMap.put(16,'p');
		charMap.put(17,'q');
		charMap.put(18,'r');
		charMap.put(19,'s');
		charMap.put(20,'t');
		charMap.put(21,'u');
		charMap.put(22,'v');
		charMap.put(23,'w');
		charMap.put(24,'x');
		charMap.put(25,'y');
		charMap.put(26,'z');
	}
	
	public static int numWays(String s) {
		
		//2 2 6
		//2 2 6
		//
		
		// i = 0 -> count 2
		// i = 1 -> count 1
		// i = 0 -> count 1
		
		// 1. if curr digit is 1 and next digit is available then add 2 to the count
		// 2. if curr digit is 2 and next digit < 7 then add 2 to the count
		// 3. check curr digit with last digit, if same then add 1 to the count
		
		int a = 1;
		int b = 1;
		
		if ( s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		
		for (int i = 1; i < s.length(); i++) {
			int tmp = a;
			
			if (s.charAt(i) == '0') {
				a = 0;
			}
			
			if (s.charAt(i-1) == '1' || (s.charAt(i-1)== '2' && s.charAt(i) <= '6')) {
				a = a + b;
			} 
			
			b = tmp;
		}
		
		return a;
		
	}

	public static void main(String[] args) {
		System.out.println(numWays("222662"));
		System.out.println(numWays("22266"));
		System.out.println(numWays("2226"));
		System.out.println(numWays("206"));
		System.out.println(numWays("0"));
		
		//222662
		
		//2 2 2 6 6 2
		//2 22 6 6 2
		//2 2 26 6 2
		//22 26 6 2
		//22 2 6 6 2
		
	}

}
