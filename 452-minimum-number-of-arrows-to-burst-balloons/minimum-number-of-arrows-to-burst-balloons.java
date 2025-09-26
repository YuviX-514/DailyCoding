class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int curr = points[0][1];
        int arrows = 1;
        boolean first = true;
        for(int a[] : points){
            if(first){
                first = false;
                continue;
            }
            if(curr >= a[0] && curr <= a[1])continue;
            else{
                curr = a[1];
                arrows++;
            }
        }
        return arrows;
    }
}