class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int curr = intervals[0][1];
        boolean first = true;

        for(int []a : intervals){
            if(first){
                first = false;
                continue;
            }
            if(curr > a[0] && curr <= a[1])count++;
            else curr = a[1];
        }

        return count;
    }
}