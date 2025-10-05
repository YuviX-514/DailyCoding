class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1)return 0;
        int n = nums.length;
        int pr = 1;
        int c = 0;
        int j = 0;
        for(int i = 0;i<n;i++){
            pr *= nums[i];
            while(j < n && pr >= k){
                pr /= nums[j];
                j++;
            }
            c += (i - j + 1);
        }
        return c;
    }
}