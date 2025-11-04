class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        Boolean dp[][] = new Boolean[m][n];
        // for(int d[] : dp)Arrays.fill(d, -1);
        return fn(s, p, m-1, n-1, dp);

    }

    public boolean fn(String s, String p, int i, int j, Boolean[][]dp){
        if(i < 0 && j < 0)return true; // both exhausted
         
        if(j < 0 && i >= 0)return false; //p phle h khatam hogyi 

        if(i < 0 && j >= 0)return allStars(p, j);  //s phle khatm hogyi 

        if(dp[i][j] != null)return dp[i][j];
        
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')return dp[i][j] = fn(s, p, i-1, j-1, dp);
        else if(p.charAt(j) == '*')return dp[i][j] = fn(s, p, i-1, j, dp) || fn(s, p, i, j-1, dp);

        else return dp[i][j] = false;
    }

    public boolean allStars(String p, int k){
        for(int i = 0; i <=k;i++){
            if(p.charAt(i) != '*')return false;
        }
        return true;
    }
}