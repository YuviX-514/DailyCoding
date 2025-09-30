class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    int atMost(int[]arr, int k){
        int count =0;
        Map<Integer, Integer> map = new HashMap<>();
        int i =0;
        int j = 0;

        while(j < arr.length){
            map.put(arr[j], map.getOrDefault(arr[j], 0)+1);

            while(map.size()> k){
                map.put(arr[i], map.get(arr[i])-1);
                if(map.get(arr[i]) == 0)map.remove(arr[i]);
                i++;
            }
            count += j-i+1;
            j++;
        }
        return count;
    }
}