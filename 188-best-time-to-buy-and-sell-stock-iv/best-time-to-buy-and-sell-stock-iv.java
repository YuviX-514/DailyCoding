class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k+1];
        for(int a[][] : dp){
            for(int b[] : a)Arrays.fill(b, -1);
        }
        return fn(prices, 0, 0, k, dp);
    }

    public int fn(int[]prices, int i, int buy, int cap, int[][][]dp){
        if(i == prices.length || cap == 0)return 0;

        if(dp[i][buy][cap] != -1)return dp[i][buy][cap];

        int profit;

        if(buy == 0){
            profit = Math.max(fn(prices, i+1, 0, cap, dp), -prices[i] + fn(prices, i+1, 1, cap, dp));
        }
        else{
            profit = Math.max(fn(prices, i+1, 1, cap, dp), prices[i] + fn(prices, i+1, 0, cap-1, dp));
        }
        return dp[i][buy][cap] = profit;
    }
}