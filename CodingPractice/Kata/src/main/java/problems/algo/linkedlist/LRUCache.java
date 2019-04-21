package problems.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	//DL Node
	class DLinkNode {
		int key;
		int val;
		DLinkNode next;
		DLinkNode prev;
	}

	//implement methods
	//1. addNode : add after head
	public void addNode(DLinkNode node) {
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
		
	}
	//2. removeNode
	public void removeNode(DLinkNode node) {
		DLinkNode prev = node.prev;
		DLinkNode next = node.next;
		
		prev.next = next;
		next.prev = prev;

	}
	//3. movetoHead
	public void moveToHead(DLinkNode node) {
		removeNode(node);
		addNode(node);
	}
	//4.popTail
	public DLinkNode popTail() {
		DLinkNode node = tail.prev;
		removeNode(node);
        
        return node;
	}
	
	private int size;
	private int capacity;
	private Map<Integer,DLinkNode> cache;
	private DLinkNode head, tail;
	
    public LRUCache(int capacity) {
    	this.size = 0;
    	this.capacity = capacity;
    	cache = new HashMap<Integer, DLinkNode>();
    	head = new DLinkNode();
    	tail = new DLinkNode();
    	
    	head.next = tail;
    	tail.prev = head;
        
    }
    
    public int get(int key) {
        DLinkNode node = cache.get(key);
        if(node == null) {
        	return -1;
        }
        removeNode(node);
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
    	//check if key present, if yes, update else follows
    	//add to cache
    	//move node to head
    	//if size > capacity evict tail
    	
    	DLinkNode node = cache.get(key);
    	
    	if(node == null) {

    		//new key
    		node = new DLinkNode();
    		node.key = key;
    		node.val = value;
    		
    		//put key-value in hashmap
    		cache.put(key, node);
    		//add node
    		addNode(node);
    		size++;
    		//check for size and popTail if needed
    		if(size > capacity) {
    			DLinkNode tail = popTail();
    			cache.remove(tail.key);
    			size--;
    		}
        } else {
    		//update existing value
    		cache.put(key,node);
    		node.val = value;
    		moveToHead(node);
    	}        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
