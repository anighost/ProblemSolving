package problems.algo.string;

/**
 * 
 * Find a pattern in a string.
 * Ex: 	inStr => "abcbcglx"
 * 		pattern = "bcgl"
 * 
 * return true
 *
 */
public class SubstringMatch {
	
	static boolean subStringMatch(String str, String pattern) {
		
		int j = 0;
		for (int i = 0; i < str.length() ; i++) {
			int k = i;
			while (j < pattern.length()) {
				if(str.charAt(k) == pattern.charAt(j)) {
					//match
					j++;
					k++;
				} else {
					//mismatch
					j = 0;
					break;
				}
				
				if (j == pattern.length()) {
					return true;
				}
			}
		}
		
		return false;
	}

	static boolean subStringMatchKNP(String str, String pattern) {
		
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subStringMatch("abcbcglx", "bcgl"));
		System.out.println(subStringMatch("abcbcglx", "bcglk"));

	}

}
