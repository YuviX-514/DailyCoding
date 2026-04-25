class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int m = houses.length;
        int n = heaters.length;

        int start = 0;
        int end = Integer.MAX_VALUE;

        int ans = 0;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(fn(houses, heaters, m, n, mid)){
                ans = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return ans;
    }

    boolean fn(int[]houses, int[]heaters, int m, int n, int r){
        int i = 0;
        int j = 0;
        while(i < m && j < n){
            int d = Math.abs(houses[i] - heaters[j]);
                if(d <= r)i++;
                else j++;
        }
        return i == m;
    }
}