class Solution {
    final static int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : roads) {
            adj.get(e[0]).add(new long[]{e[1], e[2]});
            adj.get(e[1]).add(new long[]{e[0], e[2]});
        }
        int src = 0;
        int des = n-1;
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[src] = 0;

        int w[]= new int[n];
        w[0] = 1;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int)cur[0];
            long d = cur[1];

            if(dis[node] < d) continue;
            for (long[] nbr : adj.get(node)) {
                int next =(int) nbr[0];
                long wt = nbr[1];
                if (d + wt < dis[next]) {
                    w[next] = w[node];
                    dis[next] = d + wt;
                    pq.add(new long[]{next, dis[next]});
                }
                else if(d + wt == dis[next]){
                    w[next] = (w[next] + w[node]) % MOD;
                }
            }
        }
        return w[n-1] % MOD;
        
    }
}