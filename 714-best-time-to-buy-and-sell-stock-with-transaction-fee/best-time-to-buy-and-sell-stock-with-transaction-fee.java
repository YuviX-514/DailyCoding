class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int a[] : dp){
           Arrays.fill(a, -1);
        }
        return fn(prices, 0, 0, fee, dp);
    }

    public int fn(int[]prices, int i, int buy, int fee, int[][]dp){
        if(i >= prices.length)return 0;

        if(dp[i][buy] != -1)return dp[i][buy];

        int profit;

        if(buy == 0){
            profit = Math.max(fn(prices, i+1, 0, fee, dp), -prices[i] + fn(prices, i+1, 1, fee, dp));
        }
        else{
            profit = Math.max(fn(prices, i+1, 1, fee, dp), prices[i] - fee + fn(prices, i+1, 0, fee, dp)) ;
        }
        return dp[i][buy]= profit ;
    }
}