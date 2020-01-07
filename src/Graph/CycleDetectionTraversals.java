package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CycleDetectionTraversals {

    public static void main(String[] args) {
        new CycleDetectionTraversals().solve();
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer>[] graph = createGraph(in);
        System.out.println(detectCycleDFS(graph));
        System.out.println(detectCycleBFS(graph));
    }

    private ArrayList<Integer>[] createGraph(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        return graph;
    }

    public boolean detectCycleDFS(ArrayList<Integer>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (depthFirstTraversal(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean depthFirstTraversal(ArrayList<Integer>[] graph, boolean[] vis,
                                       int node, int parent) {
        vis[node] = true;
        for (int neighbour : graph[node]) {
            if (!vis[neighbour]) {
                if (depthFirstTraversal(graph, vis, neighbour, node)) {
                    return true;
                }
            } else if (neighbour != parent && neighbour != node) {
                return true;
            }
        }
        return false;
    }

    public boolean detectCycleBFS(ArrayList<Integer>[] graph) {
        boolean[] vis = new boolean[graph.length];
        int[] parent = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            parent[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                queue.add(i);
                vis[i] = true;
                if (breadthFirstTraversal(graph, vis, queue, parent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean breadthFirstTraversal(ArrayList<Integer>[] graph, boolean[] vis,
                                         Queue<Integer> queue, int[] parent) {
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : graph[node]) {
                if (!vis[neighbour]) {
                    parent[neighbour] = node;
                    vis[neighbour] = true;
                    queue.add(neighbour);
                } else if (neighbour != parent[node] && neighbour != node) {
                    return true;
                }
            }
        }
        return false;
    }
}



