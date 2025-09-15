class Solution {
    public int helper(int idx,int target,int[]nums){
        if(idx == nums.length){
            return target == 0 ? 1 : 0;
        }
        if(idx > nums.length){
            return 0;
        }

        return helper(idx+1,target+nums[idx],nums) + helper(idx+1,target-nums[idx],nums);

    }
    public int findTargetSumWays(int[] nums, int target) {
       
        return helper(0,target,nums);
    }
}