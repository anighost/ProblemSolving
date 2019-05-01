package problems.algo.string;

/*
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

	//Naive
    public boolean isPalindrome(String s) {
        
    	if (s.isEmpty()) {
            return true;
        }
        String trimString = trimString(s);
        
        if(trimString.isEmpty()) {
            return true;
        }
        
        if(trimString.equalsIgnoreCase(reverseTrimString(s))) {
            return true;
        }
        return false;
    }
    
    private String trimString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(Character.toString(c));
            }
        }
        
        return sb.toString();
    }
    
    private String reverseTrimString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >=0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(Character.toString(c));
            }
        }
        return sb.toString();
    }

    /*****************************************************************************************/
    // Optimized
    /*****************************************************************************************/
    
    public boolean isPalindromeOptimized1(String s) {
    	if (s.isEmpty()) {
            return true;
        }
        String trimString = trimStringLowerCase(s);
        
        int i = 0, j = trimString.length()-1;
        
        while(i < j) {
        	if(trimString.charAt(i) != trimString.charAt(j)) {
        		return false;
        	}
        	i++;j--;
        }
        return true;
    }

    private String trimStringLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(Character.toString(c).toLowerCase());
            }
        }
        
        return sb.toString();
    }
    
    public boolean isPalindromeOptimized2(String s) {
    	if (s.isEmpty()) {
            return true;
        }
        int i = 0, j = s.length()-1;
        
        while(i < j) {
        	
        	if(!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))){
        		i++;
        		continue;
        	}
        	
        	if(!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j))){
        		j--;
        		continue;
        	}
        	
        	if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        		return false;
        	}
        	i++;j--;
        }
        return true;
    }

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindromeOptimized1(str));
		System.out.println(v.isPalindromeOptimized2(str));
		String str2 = "race a car";
		System.out.println(v.isPalindromeOptimized2(str2));
	}

}
