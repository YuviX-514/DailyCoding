class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int curr = 0;
        int total = 0;
        for(int i = 0;i<n;i++){
            curr += nums[i];
            max = Math.max(max, curr);
            if(curr < 0){
                curr = 0;
            }
        }

        curr = 0;
        for(int i = 0;i<n;i++){
            curr += nums[i];
            min = Math.min(min, curr);
            if(curr > 0){
                curr = 0;
            }
        }
        for(int nu : nums)total += nu;

        return total == min ? max: Math.max(max, total-min);

    }
}