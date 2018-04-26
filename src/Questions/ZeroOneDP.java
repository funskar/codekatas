package Questions;

import java.util.Scanner;

public class ZeroOneDP {
    public static void main(String[] args) {
        new ZeroOneDP().solve();
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
        String[] a = {"10", "0001", "111001", "1", "0"};
//        String[] a = {};
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm(a, m, n));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[] s0 = new int[strs.length];
        int[] s1 = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0')
                    s0[i]++;
                else
                    s1[i]++;
            }
        }
        //TOP-DOWN
        int[][][] dp = new int[m + 1][n + 1][strs.length + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= strs.length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int ans = findMaxTopDown(dp, s0, s1, m, n, strs.length);
        System.out.println(ans);

        //BOTTOM-UP
        return findMaxBottomUp(strs, m, n, s0, s1);
    }

    public int findMaxBottomUp(String[] strs, int m, int n, int[] s0, int[] s1) {
        int[][][] dp = new int[m + 1][n + 1][strs.length + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= strs.length; k++) {
                    dp[i][j][k] = 0;
                    if (k == 0) {
                        dp[i][j][k] = 0;
                    } else {
                        //recursive
                        if (i - s0[k - 1] >= 0 && j - s1[k - 1] >= 0) {
                            dp[i][j][k] = 1 + dp[i - s0[k - 1]][j - s1[k - 1]][k - 1];
                        }
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k - 1]);
                    }
                }
            }
        }
        return dp[m][n][strs.length];
    }

    public int findMaxTopDown(int[][][] dp, int[] s0, int[] s1, int m, int n, int k) {
        //base
        if (dp[m][n][k] != -1) {
            return dp[m][n][k];
        }
        dp[m][n][k] = 0;
        if (k == 0) {
            dp[m][n][k] = 0;
        } else {
            //recursive
            if (m - s0[k - 1] >= 0 && n - s1[k - 1] >= 0) {
                dp[m][n][k] = 1 + findMaxTopDown(dp, s0, s1, m - s0[k - 1], n - s1[k - 1], k - 1);
            }
            dp[m][n][k] = Math.max(dp[m][n][k], findMaxTopDown(dp, s0, s1, m, n, k - 1));
        }
        return dp[m][n][k];
    }

    public void debug(String tag, int i, int j, int k) {
        System.out.printf("%s : %d , %d , %d \n", tag, i, j, k);
    }
}

