class Solution {
    public int minPairSum(int[] nums) {
        int n =nums.length;
        int ans = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = n-1;
        while(i < j){
            int sum = nums[i] + nums[j];
            i++;
            j--;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}