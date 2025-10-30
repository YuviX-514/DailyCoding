class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [][]dp = new int[m][n];
        for(int[]d : dp)Arrays.fill(d, -1);
        int len = fn(word1, word2, m-1, n-1, dp);
        return (m + n) - 2*len;
    }

    public int fn(String w1, String w2, int i, int j, int[][]dp){
        if(i < 0 || j < 0)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if(w1.charAt(i) == w2.charAt(j))return dp[i][j] = 1 + fn(w1, w2, i-1, j-1, dp);
        else{
            return dp[i][j] = Math.max(fn(w1, w2, i-1, j, dp), fn(w1, w2, i, j-1, dp));
        }
    }
}