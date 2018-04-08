package Graph;
import java.util.ArrayList;
import java.util.LinkedList;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class DistanceCityBFS {
	
	public static void main(String[] args) {
		int[] A = {9, 1, 4, 9, 0, 4, 8, 9, 0, 1};
		int[] ans = new DistanceCityBFS().solution(A);
		for (int i = 0; i < A.length-1; i++) {
			System.out.println(ans[i]);
		}
		
	}
    public int[] solution(int[] A) {
    	int cp = -1; 
    	int[] vis = new int[A.length];
    	int[] dist = new int[A.length];
    	int[] ans = new int[A.length-1];
    	ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>(A.length);
    	for (int i = 0; i < A.length; i++) {
    		G.add(new ArrayList<Integer>());
    	}
    	for (int i = 0; i < A.length; i++) {
    	   if (A[i] == i) {
    		   cp = i;
    		   continue;
    	   } else {
    		   G.get(i).add(A[i]);
    		   G.get(A[i]).add(i);
    		   vis[i] = 0;
    	   }  
    	}
    	LinkedList<Integer> q = new LinkedList<Integer>();
    	q.add(cp);
    	vis[cp] = 1;
    	dist[cp] = 0;
    	while (!q.isEmpty()) {
    		Integer p = q.poll();
			for (Integer i : G.get(p)) {
    			if (vis[i] != 1) {
    				dist[i] = 1 + dist[p];
    				vis[i] = 1;
    				q.add(i);
    			}
			}
    	}
    	for (int i = 0; i < A.length; i++) {
    			ans[dist[i]]++;
    	}
    	return ans;
    }
}