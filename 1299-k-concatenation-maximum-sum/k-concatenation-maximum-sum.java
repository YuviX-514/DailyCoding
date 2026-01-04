class Solution {
    final static int MOD = 1_000_000_007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
       
        long sum = 0;

        long maxSum = kadane(arr);
        if(k == 1)return (int)(maxSum % MOD);

        for(int a : arr)sum += a;

        long[]p = new long[n];
        p[0] = arr[0];
        long maxP = p[0];

        for(int i=1;i<n;i++){
            p[i] = arr[i] + p[i-1];
            maxP = Math.max(p[i], maxP);
        }

        long[]s = new long[n];
        s[n-1] = arr[n-1];
        long maxS = s[n-1];

        for(int i=n-2;i>=0;i--){
            s[i] = s[i+1] + arr[i];
            maxS = Math.max(maxS, s[i]);
        }

        long res = 0;

        if(sum > 0)res = maxP + maxS + sum * (k-2);
        else res = kadaneTwice(arr);

        return (int)(Math.max(res, 0) % MOD);
    }




    private long kadane(int[] arr) {
        long max = 0, curr = 0;
        for (int x : arr) {
            curr = Math.max(x, curr + x);
            max = Math.max(max, curr);
        }
        return max;
    }

    private long kadaneTwice(int[] arr) {
        long max = 0, curr = 0;int t = 2;
        while(t-->0){
            for (int x : arr) {
                curr = Math.max(x, curr + x);
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}