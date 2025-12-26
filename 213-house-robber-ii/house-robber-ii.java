class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        int a = h(0, n-2, nums, dp);
        Arrays.fill(dp, -1);
        int b = h(1, n-1, nums, dp);

        return Math.max(a, b);
    }

    private int h (int i, int e, int[]nums, int[]dp){
        if(i > e)return 0;

        if(dp[i] != -1)return dp[i];

        int p = nums[i] + h(i+2, e, nums, dp);
        int np = h(i+1, e, nums, dp);

        return dp[i] = Math.max(p, np);
    }
}