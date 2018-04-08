package Graph;

import java.util.Scanner;

public class MatrixGraph {
    int[][] is;
    boolean[][] mem;
    int n;
    int m;
    public static void main(String[] args) {
        new MatrixGraph().solve();
    }
    
    public void solve() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        is = new int[n][m];
        mem = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                is[i][j] = in.nextInt();
                mem[i][j] = false;
            }
        }
        int maxAr = 0, currAr = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mem[i][j] == false && is[i][j] == 1) {
                    mem[i][j] = true;
                    currAr = dfs(i, j);
                    maxAr = Math.max(currAr, maxAr);
                } 
            }
        }
        System.out.print(maxAr);
    }
    
    public int dfs(int i, int j) {
        int area = 1;
        System.out.println("i : " + i + " j : " + j);
        for (int x = i-1; x <= i+1; x++) {
            if (x >= 0 && x < m) {
                for (int y = j-1; y <= j+1; y++) {
                    if (y >= 0 && y < n) {
                    	if (x == i && y == j) {
                    		continue;
                    	}
                        if (!mem[x][y] && is[x][y] == 1) {
                            mem[x][y] = true;
                            area = area + dfs(x , y);
                        }
                    }
                }
            }
        }
        return area;
    }
}
