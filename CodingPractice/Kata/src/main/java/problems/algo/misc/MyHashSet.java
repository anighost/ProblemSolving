package problems.algo.misc;

import java.util.LinkedList;

/*
 * https://leetcode.com/problems/design-hashset/
 */
public class MyHashSet {
	
	LinkedList<Integer> [] buckets;
	int num = 1000000;

	/** Initialize your data structure here. */
    public MyHashSet() {
    	buckets = new LinkedList[num];
    }
    
    public void add(int key) {
        int idx = hash(key);
        if(buckets[idx] == null) {
        	buckets[idx] = new LinkedList<Integer>();
        }
        
        if (buckets[idx].indexOf(key) == -1) buckets[idx].add(key);
    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(buckets[idx] != null) {
        	if (buckets[idx].indexOf(key) != -1) {
        		buckets[idx].remove(buckets[idx].indexOf(key));
        	}
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = hash(key);
        if (buckets[idx] == null || buckets[idx].indexOf(key) == -1) return false;
        return true;
    }
    
    int hash(int key) {
    	return Integer.hashCode(key)%num;
    }
    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
