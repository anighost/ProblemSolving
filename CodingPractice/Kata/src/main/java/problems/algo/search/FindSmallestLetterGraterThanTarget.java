package problems.algo.search;

/*
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 */
public class FindSmallestLetterGraterThanTarget {

    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        
        while (l <= r) {
            int mid = (l+r)/2;
            
            if (letters[l] > target) return letters[l];
            if(letters[mid] <= target) {
            	l = mid + 1;
            } else {
            	if (letters[mid - 1] == target) return letters[mid];
            	r = mid ;
            }
        }
        
        return letters[l%letters.length];
    }
	
	public static void main(String[] args) {
		char [] letters = new char [] {'c','f','j'};
		System.out.println(nextGreatestLetter(letters, 'j'));

	}

}
