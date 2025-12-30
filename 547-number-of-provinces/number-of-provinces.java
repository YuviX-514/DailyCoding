class Solution {
    public int findCircleNum(int[][] isConnected) {
        int c = 0;
        int n = isConnected.length;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                dfs(isConnected, set, i);
                c++;
            }
        }
        return c;

    }

    public void dfs(int[][]m, Set<Integer> set, int i){
        set.add(i);
        for(int j=0;j<m.length;j++){
            if(m[i][j] == 1 && !set.contains(j))dfs(m, set, j);
        }
    }
}