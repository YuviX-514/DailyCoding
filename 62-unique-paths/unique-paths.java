class Solution {
    public int uniquePaths(int m, int n) {
        int[][]dp = new int[m+1][n+1];
        for(int[]a:dp)Arrays.fill(a, -1);
        return helper(0, m, 0, n, dp);
    }
    int helper(int cr, int m, int cc, int n, int[][]dp){
        if(cr == m-1 && cc == n-1)return 1;
        if(cr < 0 || cc < 0 || cr > m-1 || cc > n-1)return 0;
        if(dp[cr][cc] != -1)return dp[cr][cc];
        int d = helper(cr+1, m, cc, n, dp);
        int r = helper(cr, m, cc+1, n, dp);

        return dp[cr][cc] = d + r;
    }
}