class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean visited[][] = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    pq.offer(new int[]{heightMap[i][j], i, j});
                    visited[i][j] = true;
                }
            }
        }

        int total =0;
        int dir[] = {-1, 0, 1 , 0, -1};

        while(!pq.isEmpty()){
            int []current = pq.poll();
            int ch = current[0];
            int cr = current[1];
            int cc = current[2];

            for(int k = 0;k<4;k++){
                int nr = cr + dir[k];
                int nc = cc + dir[k+1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc]){
                    total += Math.max(0, ch-heightMap[nr][nc]);
                    visited[nr][nc] = true;
                    pq.offer(new int[]{Math.max(ch, heightMap[nr][nc]), nr, nc});
                }
            }
        }
        return total;
    }
}