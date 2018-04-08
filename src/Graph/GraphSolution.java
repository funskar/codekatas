package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GraphSolution {
	public static void main(String[] args) {
			
	}
}

class Edge {
	Integer v, weight;
	public Edge(Integer v, Integer weight) {
		this.v = v;
		this.weight = weight;
	}
}

class EdgeComparator implements Comparator<Edge> {
	@Override
	public int compare(Edge e1, Edge e2) {
		if (e1.weight < e2.weight) 
			return -1;
		else if (e1.weight > e2.weight) 
			return 1;
		return 0;
	}
}

class GraphUtils {
	
	public static ArrayList<ArrayList<Edge>> createGraph(int n) {
		ArrayList<ArrayList<Edge>> G = new ArrayList<ArrayList<Edge>>(n);
		for (int i = 0; i < n; i++) {
			G.add(new ArrayList<Edge>());
		}
		return G;
	}
	
	public static void addNode(ArrayList<ArrayList<Edge>> G, Integer u, Integer v, Integer weight) {
		G.get(u).add(new Edge(v, weight));
	}
	
	public static void shortestPathDjikstra(ArrayList<ArrayList<Edge>> G, Integer source) {
		PriorityQueue<Edge> queue = new PriorityQueue<>(G.size(), new EdgeComparator());
		
	}
	
}


