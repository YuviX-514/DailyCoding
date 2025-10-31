class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][]arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr, (a,b)->Integer.compare(a[0], b[0]));
        int fleet = 1;
        double time = (double)(target - arr[n-1][0]) / arr[n-1][1];
        for(int i=n-2;i>=0;i--){
            double curr = (double)(target - arr[i][0])/arr[i][1];
            // System.out.println(time);
            // System.out.println(curr);
            if(curr > time){
                fleet += 1;
                time = curr;
            }
        }

        return fleet;
    }
}