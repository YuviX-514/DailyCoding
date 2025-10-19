class Solution {
    final int MOD = 1_000_000_007 ;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int c = 0;
        int i = 0;
        int n = nums.length;
        int j = n - 1;

        int []p = new int[n];
        p[0] = 1;
        for(int k =1;k<n;k++){
            p[k] = (p[k-1]*2 % MOD);
        }

        while(i <= j){
            if(nums[i] + nums[j] <= target){
                c = (c + p[j-i]) % MOD;
                i++;
            }
            else j--;
        }
        return c ;
    }
}