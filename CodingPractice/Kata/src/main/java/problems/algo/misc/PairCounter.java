package problems.algo.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 	John works at a clothing store. He has a large pile of socks that he must pair by color for sale. 
 * 	Given an array of integers representing the color of each sock, 
 * 	determine how many pairs of socks with matching colors there are.

	For example, there are  socks with colors . There is one pair of color  and one of color . 
	There are three odd socks left, one of each color. The number of pairs is .
 *
 */
public class PairCounter {
	
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> pairMap = new HashMap<>();
        int pairCounter = 0;

        for (int i = 0; i < ar.length; i++) {
            if(pairMap.get(ar[i]) != null && pairMap.get(ar[i]) > 0) {
                pairCounter++;
                pairMap.put(ar[i],0);
            } else {
                pairMap.put(ar[i],1);
            }
        }
        return pairCounter;
        
    }

	public static void main(String[] args) {
		int [] ar = new int [] {10 ,20 ,20 ,10 ,10 ,30 ,50 ,10 ,20};
		System.out.println(sockMerchant(9, ar));;

	}

}
