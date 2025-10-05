class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int k) {
        int n = rocks.length;
        int []diff = new int[n];
        for(int i = 0;i<n;i++){
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int c = 0;
        for(int i = 0;i<n;i++){
            if(k - diff[i] >= 0){
                c++;
                k -= diff[i];
            }
            else break;
        }
        return c;
    }
}