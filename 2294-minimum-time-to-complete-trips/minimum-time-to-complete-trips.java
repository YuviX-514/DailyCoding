class Solution {

    public static boolean isFeasible(int[]time, int totalTrips, long mid ){
        long trips = 0;

        for(int t : time){
            trips += (mid)/t;
            if(trips >= totalTrips)return true;
        }
        return false;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long start = time[0];
        long end = 0;
        
        for(int t : time){
            start = Math.min(t, start);
        }
        end = start* totalTrips;
        long result = end;

        while(start <= end){
            long mid = start + (end - start)/2;
            if(isFeasible(time, totalTrips, mid)){
                result = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return result;
    }
}