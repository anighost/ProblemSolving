package problems.algo.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * You have a set of cubes whose each side is an alphabet (which may be repeating).
 * Given an input string write a method to find whether the you can find all the characters of the string in the cubes.
 * You can take only 1 character from one cube.
 * 
 *  Assumption: No of cube is >= no of char in the input string
 *  
 *  Example:
 *  Cubes:
 *  
 *  LOVELH - L
 *  EGGPLA - E
 *  HHAGHC - H
 *  OSEEMM - O
 *  LLOYYD - L
 *  
 *  input string: "HELLO"
 *  
 *  return - true
 *
 */

public class FindStringInCubes {
	
	
	static boolean findString(List<String> cubes, String inStr) {
		
		
		if(cubes == null || cubes.isEmpty() || inStr == null || inStr.isEmpty() || cubes.size() < inStr.length()) {
			return false;
		}
		
		return recurFind(cubes, inStr, 0);
	}
	
	static boolean recurFind(List<String> cubes, String str, int pos) {
		
		if(pos == str.length()) {
			//match found
			return true;
		}

		for (int i = 0; i < cubes.size(); i++) {
			if (cubes.get(i).contains(Character.toString(str.charAt(pos)))) {
				//match found for the char
				//remove the element from tmpCubes and check for the next char;
				List<String> tmpCubes = new ArrayList<String>(cubes);
				tmpCubes.remove(i);
				if(recurFind(tmpCubes, str, pos+1)) {
					return true;
				}
				//else continue loop looking for the next element of the list
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "EGGPLA";
		String s2 = "LOVELH";
		String s3 = "HHAGHC";
		String s4 = "OSEEMM";
		String s5 = "LLOYYD";
		
		List<String> l1 = new ArrayList<String>();
		l1.add(s1);
		l1.add(s2);
		l1.add(s3);
		l1.add(s4);
		l1.add(s5);
		
		System.out.println(findString(l1, "HELLO")); //true
		System.out.println(findString(l1, "HHHHHH")); //false
		System.out.println(findString(l1, "DOVEG")); //true
		System.out.println(findString(l1, "")); //false
		System.out.println(findString(l1, "HELLOL")); //false
		
	}

}
