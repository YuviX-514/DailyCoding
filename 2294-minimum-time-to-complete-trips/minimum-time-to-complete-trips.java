class Solution {
    public long minimumTime(int[] time, int totalTrips) {
       
        Arrays.sort(time);
        long start = time[0];
        long end = start * totalTrips;

        long ans = end;

        while(start <= end){
            long mid = start + (end - start)/2;

            if(h(time, totalTrips, mid)){
                ans = mid;
                end = mid - 1;
            }
            else start = mid +1 ;                                                                         
        }
        
        return ans;
    }

    public boolean h(int time[], int k, long mid){
        int trips = 0;
        for(int i =0;i<time.length;i++){
            trips += (mid/time[i]);
            if(trips >= k)return true;
        }
        return false;
    }
}