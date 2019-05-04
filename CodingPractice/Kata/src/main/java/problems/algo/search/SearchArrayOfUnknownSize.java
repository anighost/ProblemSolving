package problems.algo.search;

import problems.algo.utils.ArrayReader;

/*
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 */
public class SearchArrayOfUnknownSize {

	public int search(ArrayReader reader, int target) {

		int l = 0;
        int r = Integer.MAX_VALUE;
        
        while (l <= r) {
            int mid = l + (r -l)/2;
            
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;        

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
