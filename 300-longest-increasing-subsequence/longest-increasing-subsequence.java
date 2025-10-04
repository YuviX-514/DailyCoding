class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            int idx = lb(n, list);
            if(list.size() == idx)list.add(n);
            else list.set(idx, n);
        }
        return list.size();
    }

    public int lb(int target, List<Integer> list){
        int start = 0;
        int end =list.size();
        int ans = -1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(list.get(mid) < target)start = mid + 1;
            else end = mid;
        }
        return start;
    }
}