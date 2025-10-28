class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[]d : dp)Arrays.fill(d, -1);
        
        int ans =  helper(coins, coins.length - 1, amount, dp);
        return ans >= (int)1e9 ? -1 : ans;
    }

    public int helper(int[]coins, int i, int a, int[][]dp){
        if(i == 0){
            if(a % coins[0] == 0)return a/coins[0];
            else return (int)1e9;
        }
        if(dp[i][a] != -1)return dp[i][a];

        int take = (int)1e9;
        if(coins[i] <= a)take = 1 + helper(coins, i, a-coins[i], dp);
        int notTake = helper(coins, i-1, a, dp);

        return dp[i][a] = Math.min(take, notTake);
    }

}