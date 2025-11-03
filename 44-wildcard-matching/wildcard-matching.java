class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length()+1][p.length()+1];
        return fn(s, p, 0, 0, dp);
    }

    public boolean fn(String s, String p, int i, int j, Boolean[][]dp){
        if(i == s.length() && j == p.length())return true;
        
        if(j == p.length())return false;

        if(dp[i][j] != null)return dp[i][j];

        boolean ans;

        if(p.charAt(j) == '*')ans = fn(s, p, i, j+1, dp) || (i<s.length() && fn(s, p, i+1, j, dp));
        else if( (i < s.length())&& (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'))ans = fn(s, p, i+1, j+1, dp);
        else ans = false;

        return dp[i][j] = ans;
    }
}