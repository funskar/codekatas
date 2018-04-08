package Graph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class GraphTopoSortProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();

		while (q > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int heads[] = new int[m];
			Graph g = new Graph(n);
			for (int i = 0; i < n; i++) {
				int c = in.nextInt();
				if (c > 0) {
					for (int j = 0; j < c; j++) {
						g.addEdge(i, (in.nextInt()) - 1);
					}
				}
			}
			for (int i = 0; i < m; i++) {
				heads[i] = in.nextInt() - 1;
			}
			for (int i = 0; i < m; i++) {
				g.bfs(heads[i]);
			}
			g.inverseGraph();
			//g.p();
			g.topologicalSortModified();
			System.out.println(g.result.size());
			// System.out.println(g.result);
			for (Iterator iterator = g.result.iterator(); iterator.hasNext();) {
				Integer i = (Integer) iterator.next();
				System.out.print(i + 1 + " ");

			}
			q--;
			System.out.print("\n");
		}
	}
}

class Graph {
	private int v;
	private ArrayList<Integer> adj[];
	public int inDegree[];
	public ArrayList<Integer> result;
	public int visited[];
	public Graph newG;

	public Graph(int v) {
		this.v = v;
		this.adj = new ArrayList[v];
		this.inDegree = new int[v];
		this.result = new ArrayList<Integer>();
		this.visited = new int[v];
		for (int i = 0; i < v; i++) {
			inDegree[i] = 0;
			visited[i] = 0;
			adj[i] = new ArrayList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public void bfs(Integer v) {
		LinkedList<Integer> q = new LinkedList<>();
		visited[v] = 1;
		q.add(v);
		while (q.size() != 0) {
			int s = q.poll();
			Iterator<Integer> i = adj[s].iterator();
			while (i.hasNext()) {
				int n = i.next();
				if (visited[n] == 0) {
					visited[n] = 1;
					q.add(n);
				}
					
			}
		}
	}

	public void inverseGraph() {
		newG = new Graph(v);
		for (int i = 0; i < adj.length; i++) {
			for (Integer n : adj[i]) {
				if (visited[n] == 1 && visited[i] == 1) {
					newG.addEdge(n, i);
					this.inDegree[i]++;
				}
			}
		}
	}
	
	public void p() {
		for (int i = 0; i < newG.adj.length; i++) {
			for (Integer n : newG.adj[i]) {
				System.out.print(i + " index " + n + " ");
			}
			System.out.print("\n");
		}
	}

	public void topologicalSortModified() {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for (int i = 0; i < this.v; i++) {
			if (this.inDegree[i] == 0 && this.visited[i] == 1) {
				ts.add(i);
			}
		}
		while (ts.size() != 0) {
			Integer r = ts.pollFirst();
			result.add(r);
			Iterator<Integer> j = newG.adj[r].iterator();
			while (j.hasNext()) {
				int n = j.next();
				if (this.visited[n] == 1) {
					this.inDegree[n]--;
					if(this.inDegree[n] == 0) {
						ts.add(n);
					}
				}
			}
		}
	}

}
