package Questions;

import java.util.Scanner;

public class MaxXorArrayDP {
    public static void main(String[] args) {
        new MaxXorArrayDP().dpSolve();
    }

    public void dpSolve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        int l = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            l = Math.max(l, a[i]);
        }
        int[][] dp = new int[n + 1][1024];
        dp[0][0] = 0;
        for (int j = 1; j <= 1023; j++) {
            dp[0][j] = -1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1023; j++) {
                if (dp[i - 1][j ^ a[i]] == -1)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j ^ a[i]] + 1));
            }
        }
        int M = 1000000007;
        int i = l;
        int sum = 0;
        while (i >= 0) {
            sum = (sum * 31 + dp[n][i]) % M;
            i--;
        }
        System.out.println(sum);
    }
}

