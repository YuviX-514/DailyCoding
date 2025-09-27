class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums)pq.add(n);
        int nn = nums.length;
        int x = nn-k;
        while(x--> 0)pq.poll();

        return pq.poll();
    }
}