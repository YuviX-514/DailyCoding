class Solution {
    public int maxProfit(int[] prices) {
        int h1 = Integer.MIN_VALUE;
        int s1= 0;
        int h2 = Integer.MIN_VALUE;
        int s2 = 0;

        for(int p : prices){
            h1 = Math.max(h1, -p);
            s1 = Math.max(s1, p + h1);
            h2 = Math.max(h2, -p + s1);
            s2 = Math.max(s2, p + h2);
        }

        return s2;
    }
}