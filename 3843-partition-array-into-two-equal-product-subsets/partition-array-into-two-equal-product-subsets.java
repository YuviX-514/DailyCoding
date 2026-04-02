class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        long p = 1;
        for(int x : nums)p *= x;
        if(target*target != p)return false;

        return dfs(nums, 0, target);
    }

    public boolean dfs(int[]nums, int i, long target){
        if(target == 1)return true;
        if(i == nums.length)return false;

        if(dfs(nums, i+1, target))return true;

        if(target % nums[i] == 0){
            if(dfs(nums, i+1, target/nums[i]))return true;
        }
        return false;
    }
}