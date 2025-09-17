class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        while(n > 1){
            int []temp = new int[n-1];

            for(int i = 0;i<n-1;i++){
                temp[i] = (nums[i] + nums[i+1])%10;
            }
            nums = temp;
            n = nums.length;
        }

        return nums[0];
    }
}