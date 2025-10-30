class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int i =0;
        int j = n-1;
        int op = 0;
        StringBuilder sb = new StringBuilder(s);
        int dp[][] = new int[n][n];
        for(int d[]: dp)Arrays.fill(d, -1);
        return fn(sb, i, j, dp);
    }

    public int fn(StringBuilder sb, int i, int j, int[][]dp){
        if(i >= j)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        if(sb.charAt(i) == sb.charAt(j))return dp[i][j] = fn(sb, i+1, j-1, dp);
        else{
            return dp[i][j] = (1 + Math.min(fn(sb, i+1, j, dp), fn(sb, i, j-1, dp)));
        }
    }
}