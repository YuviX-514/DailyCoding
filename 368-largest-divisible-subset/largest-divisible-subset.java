class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];Arrays.fill(dp, 1);
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);

        int p[] = new int[n];
        for(int i=0;i<n;i++)p[i] = i;

        int maxLen = 1, idx = 0;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if((arr[i] % arr[j] == 0)  && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    p[i] = j;
                }
            }
            if(maxLen < dp[i]){
                maxLen = dp[i];
                idx = i;
            }
        }

        while(p[idx] != idx){
            list.add(arr[idx]);
            idx = p[idx];
        }
        list.add(arr[idx]);
        Collections.reverse(list);
        return list;
    }
}