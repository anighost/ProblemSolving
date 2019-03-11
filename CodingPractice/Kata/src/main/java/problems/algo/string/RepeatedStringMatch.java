package problems.algo.string;

/**
 * 
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. 
 * If no such solution, return -1.

	For example, with A = "abcd" and B = "cdabcdab".
	
	Return 3, because by repeating A three times ("abcdabcdabcd"), B is a substring of it; 
	and B is not a substring of A repeated two times ("abcdabcd").
	
	Note:
	The length of A and B will be between 1 and 10000.

 *
 */
public class RepeatedStringMatch {
	
    public static int repeatedStringMatch(String A, String B) {
    	
    	int count = 1;
    	StringBuilder sb = new StringBuilder(A);
    	
    	while (sb.length() < B.length()) {
    		count++;
    		sb.append(A);
    	}
    	
    	if(sb.toString().contains(B) ) {
    		return count;
    	}
    	
    	if (sb.append(A).toString().contains(B)) {
    		return count+1;
    	}
    	
    	return -1;
        
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(repeatedStringMatch("a", "aa"));

	}

}
