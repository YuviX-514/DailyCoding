class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int dp[][] = new int[m+2][m+2];
        for(int []a : dp)Arrays.fill(a, -1);
        
        int[]pos = new int[m+2];
        pos[0] = 0;
        pos[m+1] = n;
        int idx = 1;
        for(int i=0;i<m;i++)pos[idx++] = cuts[i];
        Arrays.sort(pos);
        return fn(pos, 0, m+1, dp);
    }

    public int fn(int[]pos, int i, int j, int[][]dp){

        if(i+1 == j)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k = i+1;k<j;k++){
            int ans = fn(pos, i, k, dp) + fn(pos, k, j, dp) + pos[j] - pos[i];
            min = Math.min(min, ans);
        }

        return dp[i][j] = min;
    }
}