class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m][n];
        for(int[] d:dp)Arrays.fill(d, -1);

        return dfs(dungeon, 0, 0, dp);
    }

    public int dfs(int[][]dungeon, int i, int j, int[][]dp){
        if(i >= dungeon.length || j >= dungeon[0].length)return Integer.MAX_VALUE;
        if(i == dungeon.length-1 && j == dungeon[0].length-1)return Math.max(1, 1-dungeon[i][j]);
        
        if(dp[i][j] != -1)return dp[i][j];

        int down = dfs(dungeon, i+1, j, dp);
        int right = dfs(dungeon, i, j+1, dp);

        return dp[i][j] = Math.max(1, Math.min(down, right)-dungeon[i][j]);
    }
}