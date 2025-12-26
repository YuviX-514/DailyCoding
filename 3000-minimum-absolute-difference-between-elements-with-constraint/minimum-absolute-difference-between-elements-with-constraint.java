class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        // int min = Integer.MAX_VALUE;
        // for(int i=0; i<n; i++){
        //     for(int j=i+x;j<n;j++){
        //         min = Math.min(min, Math.abs(nums.get(i) - nums.get(j)));
        //     }
        // }
        // return min;
        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for(int i=x; i<n;i++){
            set.add(nums.get(i-x));

            Integer f = set.floor(nums.get(i));
            Integer c = set.ceiling(nums.get(i));

            if(f != null)ans = Math.min(ans, Math.abs(f - nums.get(i)));
            if(c != null)ans = Math.min(ans, Math.abs(c - nums.get(i)));
        }

        return ans;
    }
}