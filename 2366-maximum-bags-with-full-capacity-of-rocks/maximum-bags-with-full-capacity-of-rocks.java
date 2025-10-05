class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int ar) {
        int n = rocks.length;
        Pair[] arr = new Pair[n];
        for(int i = 0;i < n;i++){
            arr[i] = new Pair(capacity[i], rocks[i]);
        }
        Arrays.sort(arr, (a, b)->(Integer.compare((a.c - a.r), (b.c-b.r))));

        
        int op = 0;
        for(int i = 0;i<n;i++){
            int ch = arr[i].c - arr[i].r;
            ar -= ch;
            if(ar < 0)break;
            op++;

        }
        return op;
        
    }
    class Pair{
        int c;
        int r;
        Pair(int c, int r){
            this.c = c;
            this.r = r;
        }
    }
}