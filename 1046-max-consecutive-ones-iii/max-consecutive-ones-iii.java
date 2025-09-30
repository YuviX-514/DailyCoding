class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroes = 0;
        int i = 0;
        int len = 0;
        for(int j = 0;j<nums.length;j++){
            if(nums[j] == 0)zeroes++;
            while( zeroes > k){
                if(nums[i] == 0)zeroes--;
                i++;
            }
            len = Math.max(len, j-i+1);
        }

        return len;
    }
}