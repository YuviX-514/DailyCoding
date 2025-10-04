class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            for(int j= 0;j<i;j++){

                if(nums[i] > nums[j])dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int n : dp)max = Math.max(max, n);
        return max+1;
    }
}