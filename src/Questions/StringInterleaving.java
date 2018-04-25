package Questions;

public class StringInterleaving {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        System.out.println(new StringInterleaving().isInterleaveBottomUp(s1, s2, s3));
        System.out.println(new StringInterleaving().isInterleaveTopDown(s1, s2, s3));
    }

    public int solve(int[][] dp, String s1, String s2, String s3, int i, int j) {
        //base case
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == 0) {
            dp[i][j] = s2.substring(0, j).equals(s3.substring(0, i + j)) ? 1 : 0;
        } else if (j == 0) {
            dp[i][j] = s1.substring(0, i).equals(s3.substring(0, i + j)) ? 1 : 0;
        } else {
            //recursive
            dp[i][j] = 0;
            if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                dp[i][j] = solve(dp, s1, s2, s3, i - 1, j);
            }
            if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j] == 0) {
                dp[i][j] = solve(dp, s1, s2, s3, i, j - 1);
            }
        }
        return dp[i][j];
    }

    public boolean isInterleaveTopDown(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        int ans = solve(dp, s1, s2, s3, s1.length(), s2.length());
        return (ans == 1) ? true : false;
    }

    public boolean isInterleaveBottomUp(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                } else {
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (!dp[i][j] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}



