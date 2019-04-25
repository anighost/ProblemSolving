package problems.algo.treesgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {

	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }

		@Override
		public String toString() {
			return "Node [val=" + val + ", neighbors=" + neighbors + "]";
		}
	    
	}
	
	public Node cloneGraph(Node node) {
		
		Queue<Node> q = new LinkedList<Node>();
		Map<Node, Node> map = new HashMap<Node, Node>();
        map.put(node, new Node(node.val, new ArrayList<>()));
		q.offer(node);
		
		while (!q.isEmpty()) {
			
			//get node 
			Node curr = q.poll();
			for (Node next : curr.neighbors) {
				
				if(map.get(next) == null) {
					map.put(next, new Node(next.val, new ArrayList<Node>()));
					q.offer(next);
				}
				map.get(curr).neighbors.add(map.get(next));
			}
			
		}

		return map.get(node);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloneGraph c = new CloneGraph();
		Node n1 = c.new Node(1, new ArrayList<Node>());
		Node n2 = c.new Node(2, new ArrayList<Node>());
		Node n3 = c.new Node(3, new ArrayList<Node>());
		Node n4 = c.new Node(4, new ArrayList<Node>());
		
		n3.neighbors.add(n4);
		n3.neighbors.add(n2);
		
		n2.neighbors.add(n3);
		n2.neighbors.add(n1);
		
		n1.neighbors.add(n2);
		n1.neighbors.add(n4);

		n4.neighbors.add(n1);
		n4.neighbors.add(n3);
		
		Node n5 = c.cloneGraph(n2);

	}

}
