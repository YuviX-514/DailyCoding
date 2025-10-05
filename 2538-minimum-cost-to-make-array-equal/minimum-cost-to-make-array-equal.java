class Solution {
    class Pair{
        long n;
        long c;

        Pair(long n , long c){
            this.n = n;
            this.c = c;
        }
    }
    public long minCost(int[] nums, int[] cost) {
        List<Pair> list = new ArrayList<>();
        int n =nums.length;
        for(int i = 0;i<n;i++){
            list.add(new Pair(nums[i], cost[i]));
        }

        Collections.sort(list, (a, b)->Long.compare(a.n, b.n));

        long total = 0;
        for(Pair p : list)total += p.c;
        long k = (total + 1)/2;
        
        long sum = 0;
        long med = 0;
        for(Pair p : list){
            sum += p.c;
            if(sum >= k){
                med = p.n;
                break;
            }
        }
        long cs = 0;

        for(Pair p : list){
            cs += (long)Math.abs(p.n-med)*p.c;
        }
        return cs;
    }
}