class Solution {
    public int helper(int idx,int target,int[]nums, Map<String, Integer> dp ){
        if(idx == nums.length){
            return target == 0 ? 1 : 0;
        }
        if(idx > nums.length){
            return 0;
        }
        String key = idx+", "+target;
        if(dp.containsKey(key))return dp.get(key);

        int total = helper(idx+1,target+nums[idx],nums, dp) + helper(idx+1,target-nums[idx],nums, dp);
        dp.put(key, total);
        return total;

    }
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return helper(0,target,nums, dp);
    }
}