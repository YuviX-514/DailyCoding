class Solution {
    public boolean canPartition(int[] nums) {

        int t = 0;
        for(int n : nums)t+=n;
        if(t%2 !=0)return false;
        int dp[][] = new int[nums.length][t/2+1];
        for(int[]a : dp)Arrays.fill(a, -1);
        return f(nums.length - 1, t/2, nums, dp);
    }

    public boolean f(int i, int t, int[]a, int dp[][]){
        if(t == 0)return true;
        if(i == 0)return a[i] == t;

        if(dp[i][t] != -1)return dp[i][t] == 0 ? false : true;

        boolean ntk = f(i-1, t, a, dp);
        boolean tk = false;

        if(a[i]<=t){
            tk = f(i-1, t-a[i],a, dp);
        }

        dp[i][t] = ntk || tk ? 1 : 0;

        return tk||ntk;
    }
}