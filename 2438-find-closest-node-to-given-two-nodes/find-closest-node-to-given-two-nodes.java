class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int dis1[] = new int[edges.length];
        int dis2[] = new int[edges.length];

        boolean[]v1 = new boolean[edges.length];
        boolean[]v2 = new boolean[edges.length];

        dfs(v1, dis1, node1, edges);
        dfs(v2, dis2, node2, edges);
        int d = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0; i<edges.length; i++){
            if(v1[i] && v2[i] && Math.max(dis1[i], dis2[i]) < d){
                d = Math.max(dis1[i], dis2[i]);
                ans = i;
            }

        }
        return ans;
        
    }

    public void dfs(boolean[]v, int[] dis, int node, int[]edges){

        v[node] = true;

        int c = edges[node];

        if(c!= -1 && !v[c]){
            dis[c] = dis[node]+1;

            dfs(v, dis, c, edges);
        }
    }
}