package problems.algo.misc;

/*
 * https://leetcode.com/problems/design-hashmap/
 */
public class MyHashMap {
    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    ListNode[] nodes;

    /** Initialize your data structure here. */
    public MyHashMap() {
    	nodes = new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
    	int idx = idx(key);
    	if (nodes[idx] == null) {
    		nodes[idx] = new ListNode(-1,-1); //dummy head
    	}
    	ListNode prev = find(nodes[idx], key);
    	if (prev.next == null) {
    		prev.next = new ListNode(key,value);    		
    	} else {
    		prev.next.val = value;
    	}
    	
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	int idx = idx(key);
    	if(nodes[idx] == null) return -1;
    	ListNode prev = find(nodes[idx], key);
    	if(prev.next == null) return -1;
    	return prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	int idx = idx(key);
    	if(nodes[idx] != null) {
        	ListNode prev = find(nodes[idx], key);
        	if(prev.next != null) {
        		prev.next = prev.next.next;        	
        	}
    	}
    }
    
    int idx(int key) { return Integer.hashCode(key) % nodes.length;}
    
    ListNode find(ListNode bucket, int key) {
    	ListNode curr = bucket;
    	ListNode prev = null;
    	
    	while (curr != null && curr.key != key) {
    		prev = curr;
    		curr = curr.next;
    	}
    	
    	return prev;    	
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
