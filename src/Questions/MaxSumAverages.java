package Questions;

//https://leetcode.com/articles/largest-sum-of-averages/

public class MaxSumAverages {


    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] B = {9, 1, 2, 3, 9};
        new MaxSumAverages().solve(B, 3);
    }

    public void solve(int[] A, int k) {
        int[][] dp = new int[k + 1][A.length];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < A.length; j++) {
                dp[i][j] = -1;
            }
        }
        int[] P = new int[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            P[i] = sum + A[i];
            sum = P[i];
        }
        findMaxAvg(dp, P, A.length - 1, k);
        System.out.println(dp[k][A.length - 1]);
    }

    public int findMaxAvg(int[][] dp, int[] P, int i, int k) {
        if (dp[k][i] != -1) {
            return dp[k][i];
        }
        if (k == 0) {
            dp[k][i] = getAvg(P, 0, i);
            return dp[k][i];
        }
        dp[k][i] = getAvg(P, 0, i);
        for (int j = 0; j < i; j++) {
            dp[k][i] = Math.max(dp[k][i],
                    getAvg(P, j + 1, i) + findMaxAvg(dp, P, j, k - 1));
        }
        return dp[k][i];
    }

    public int getAvg(int[] P, int i, int j) {
        if (i == 0) {
            return P[j] / (j + 1);
        }
        return (P[j] - P[i - 1]) / (j - i + 1);
    }

}


