package Graph;
import java.util.*;

class GraphHacker {
    /** Edge weight **/
    private static int EDGE_DISTANCE;
    /** Track distance to 'start' node **/
    public int[] distance;
    /** GraphHacker where index is 0-indexed node ID and each element is the set of neighboring nodes. **/
    public ArrayList<HashSet<Integer>> GraphHacker;
    /** Starting node number for BFS, default Java initialization is to node 0 **/
    public int start;
    
    public GraphHacker(int n, int edgeWeight) {
        this.EDGE_DISTANCE = edgeWeight;
        this.distance = new int[n];
        Arrays.fill(distance, -1);
        this.GraphHacker = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < n; i++) {
            this.GraphHacker.add(new HashSet<Integer>());
        }
    }
    
    public void shortestReach(int s) {
        this.start = s;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        distance[start] = 0;
        // BFS from start
        while (queue.size() > 0) {
            int u = queue.remove();
            // for each unvisited neighbor of the current node
            for (int v : GraphHacker.get(u)) {
                // Add unvisited neighboring nodes to queue to check its neighbors at next level of the search, set distance
                if (distance[v] == -1) {
                    queue.add(v);
                    distance[v] = distance[u] + EDGE_DISTANCE;
                }
            }
        }
        for (int i : distance) {
            if (i != 0) {
                System.out.print(i + " ");
            } 
        }
        System.out.println();
        // Just resets all distances to -1 in the event that this method is ever called multiple times for some different 's'.
        Arrays.fill(distance, -1);
    }
}

public class GraphHackerBFS {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        for(int t = 0; t < queries; t++) {
            // Create a GraphHacker of size n where each edge weight is 6:
            GraphHacker bfs = new GraphHacker(scanner.nextInt(), 6);
            int m = scanner.nextInt();
            // read and set edges
            for(int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                // add each edge to the GraphHacker
                bfs.GraphHacker.get(u).add(v);
                bfs.GraphHacker.get(v).add(u);
            }
            // Find shortest reach from node s
            bfs.shortestReach(scanner.nextInt() - 1);
        }
        scanner.close();
    }
}
