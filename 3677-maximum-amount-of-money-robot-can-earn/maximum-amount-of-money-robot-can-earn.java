class Solution {
    int m, n;
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        int[][][]dp = new int[m][n][3];

        for(int[][]d : dp){
            for(int[]a : d){
                Arrays.fill(a, (int)-1e9);
            }
        }

        return solve(coins, 0, 0, 2, dp);
        
    }

    public int solve(int[][]coins, int i, int j, int k, int[][][]dp){
        if(i == m || j == n)return (int)(-1e9);

        int c = coins[i][j];

        if(i == m - 1 && j == n-1){
            if(c < 0 && k > 0)return 0;
            return c;
        }
        if(dp[i][j][k] != (int)(-1e9))return dp[i][j][k];
        int ans = 0;

        int d  = c + solve(coins, i+1, j, k, dp);
        int r  = c + solve(coins, i, j+1, k, dp);

        ans = Math.max(d, r);

        //neutralize it baby !!!!

        if(k > 0 && c < 0){
            int dk = solve(coins, i+1, j, k-1, dp);
            int rk = solve(coins, i, j+1, k-1, dp);

            ans = Math.max(ans, Math.max(dk, rk));
        }
        return dp[i][j][k] = ans;

    }
}