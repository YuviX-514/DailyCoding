class Solution {
    public int rob(int[] nums) {
        int n= nums.length;

        if(n == 1)return nums[0];
        if(n == 2)return Math.max(nums[0], nums[1]);

        int case1 = helper(nums, 0, n-2);
        int case2 = helper(nums, 1, n-1);
        return Math.max(case1, case2);
    }
    public int helper(int[] nums, int start, int end) {
        int n =  end- start + 1;
        int [] dp = new int[n];
        dp[0] = nums[start];
        
        for(int i = 1;i<n;i++){
            int pick = nums[start + i];
            if(i > 1)pick += dp[i-2];
            int notPick = 0 + dp[i-1]; 

            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }
}

