package Graph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CycleDetectionGraph {
	
	public ArrayList<Integer> adj[];
	public int n;
	public static int result;
	public int b[];
	public int vis[];
	public static Scanner in;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CycleDetectionGraph cd = new CycleDetectionGraph();
		in = new Scanner(System.in);
		cd.createGraph(in);
		System.out.println(cd.countCycles() + cd.inputSeq(in));
		System.out.println(result);
	}
	
	public int inputSeq(Scanner in) {
		b = new int[adj.length];
		int cnt = 0;
		for (int i = 0; i < adj.length; i++) {
			b[i]  = in.nextInt();
			if (b[i] == 1) {
				cnt++;
			}
		}
		if (cnt % 2 == 0)
			return 1;
		return 0;
	}

	public void createGraph(Scanner in) {
		n = in.nextInt();
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
			adj[i].add(in.nextInt()-1);
		}
	}
	
	public int countCycles() {
		result = 0;
		vis = new int[n];
		for (int i = 0; i < adj.length; i++) {
			vis[i] = 0;
		}
		for (int i = 0; i < adj.length; i++) {
			if (vis[i] == 0) {
				DFS(i);
				result++;
			}
		}
		if (result == 1)
			result = 0;
		return result;
	}
	
	public void DFS(int i) {
		vis[i] = 1;
		for (Iterator it = adj[i].iterator(); it.hasNext();) {
			Integer v = (Integer)it.next();
			if (vis[v] == 0) {
				DFS(v);
			}
		}	
	}
	

}
