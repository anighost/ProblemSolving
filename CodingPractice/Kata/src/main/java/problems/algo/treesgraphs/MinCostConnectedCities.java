package problems.algo.treesgraphs;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MinCostConnectedCities {


	int getMinimumCostToConstruct(int numTotalAvailableCities, 
			int numTotalAvailableRoads, 
			List<List<Integer>> roadsAvailable, 
			int numNewRoadsConstruct, 
			List<List<Integer>> costNewRoadsConstruct)
	{
		// WRITE YOUR CODE HERE
		Set<Edge> edges = buiildConnections(roadsAvailable, costNewRoadsConstruct);
		return findCost(numTotalAvailableCities, edges);
	}
	// METHOD SIGNATURE ENDS


	private static Set<Edge> buiildConnections(List<List<Integer>> roadsAvailable, List<List<Integer>> costNewRoads) {
		Set<Edge> edges = new HashSet<>();
		for (List<Integer> road : roadsAvailable) {
			edges.add(new Edge(road.get(0), road.get(1), 0));
		}
		for (List<Integer> road : costNewRoads) {
			edges.add(new Edge(road.get(0), road.get(1), road.get(2)));
		}
		return edges;
	}

	private static int findCost(int numCities, Set<Edge> edges) {
		Queue<Edge> pq = new PriorityQueue<>(edges);
		Union uf = new Union(numCities + 1);
		int mstSize = 0;
		int totalCost = 0;
		while (!pq.isEmpty() && mstSize < numCities - 1) {
			Edge edge = pq.poll();
			if (!uf.connected(edge.u, edge.v)) {
				uf.union(edge.u, edge.v);
				totalCost += edge.cost;
				mstSize++;
			}

		}
		return totalCost;
	}
}

class Edge implements Comparable<Edge> {
	int v;
	int u;
	int cost;

	public Edge(int v, int u, int cost) {
		this.v = v;
		this.u = u;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge that) {
		return Integer.compare(this.cost, that.cost);
	}
}

class Union {
	private int[] parent;
	private byte[] weight;

	public Union(int n) {
		if (n < 0) throw new IllegalArgumentException();
		parent = new int[n];
		weight = new byte[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public int find(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int pr = find(p);
		int qr = find(q);
		if (pr == qr) return;
		if (weight[pr] < weight[qr]) {
			parent[pr] = qr;
		} else {
			parent[qr] = pr;
			if (weight[pr] == weight[qr]) weight[pr]++;
		}
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

}
