package problems.algo.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Play {

	public static void main(String[] args) {
		String s = "MCMXCIV";
		// M -> 0
		// CM -> 1
		// XC -> 3
		// IV -> 5
		
		//1000*1 + 900*1 + 90 + 4
		
//		String ss1 = "M";
//		String ss2 = "C";
//		String ss3 = "X";
//		String ss4 = "IV";
//		
//		System.out.println(s.indexOf(ss1));
//		System.out.println(s.indexOf(ss2));
//		System.out.println(s.indexOf(ss3));
//		System.out.println(s.indexOf(ss4));
//		System.out.println(s.indexOf("A"));
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(2);
		
		System.out.println(list);
		int l = list.size()-1 ;
		list.remove(l);
		System.out.println(list);
		
		System.out.println("HELLO".substring(1,2));
		
	}

}
