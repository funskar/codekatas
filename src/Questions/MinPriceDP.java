package Questions;

public class MinPriceDP {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(new MinPriceDP().minPrice(A));
    }

    public int minPrice(int[] A) {
        int dp[] = new int[35];
        dp[0] = 0;
        for (int i = 0; i < A.length; i++) {
            dp[i + 1] = Math.min(2 + dp[getLast(A, A[i] - 1)], 7 + dp[getLast(A, A[i] - 7)]);
            dp[i + 1] = Math.min(dp[i + 1], 25 + dp[getLast(A, A[i] - 30)]);
        }
        return dp[A.length];
    }

    public int getLast(int[] A, int i) {
        int d = -1;
        int n = A.length;
        for (int k = n - 1; k >= 0; k--) {
            if (A[k] <= i) {
                d = k;
                break;
            }
        }
        return d + 1;
    }

}