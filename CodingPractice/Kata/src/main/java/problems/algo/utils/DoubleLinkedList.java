package problems.algo.utils;

public class DoubleLinkedList {
    Node head, tail;
    
    public DoubleLinkedList() {
        this.head = new Node(0);
        this.tail = new Node(0);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public Node add(int val) {
        Node x = new Node(val);
        x.next = tail;
        x.prev = tail.prev;
        tail.prev = tail.prev.next = x;
        return x;
    }
    
    public Node unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
    
    public int pop() {
        return unlink(tail.prev).val;
    }

    public int peek() {
        return tail.prev.val;
    }    
}
