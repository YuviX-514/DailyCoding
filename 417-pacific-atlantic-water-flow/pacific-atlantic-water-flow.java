class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        for(int i = 0;i<m;i++){
            dfs(heights, p, i, 0);
            dfs(heights, a, i, n-1);
        }
        for(int j = 0;j<n;j++){
            dfs(heights, p, 0, j);
            dfs(heights, a, m-1, j);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i= 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(p[i][j] && a[i][j])res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    public void dfs(int[][]heights, boolean[][]visit, int i, int j){
        visit[i][j] = true;
        for(int d[] : dirs){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni<0 || ni>=heights.length || nj<0 || nj>=heights[0].length) continue;
            if(visit[ni][nj])continue;
            if(heights[ni][nj] < heights[i][j])continue;

            dfs(heights, visit, ni, nj);

        }}
    
}