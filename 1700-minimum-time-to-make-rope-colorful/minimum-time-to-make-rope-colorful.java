class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int curr = 0;
        int n = colors.length();

        for(int i=0;i<n;i++){
            if(i == 0 || colors.charAt(i) != colors.charAt(i-1))curr = neededTime[i];
            else{
                if(neededTime[i] > curr){
                    ans += curr;
                    curr = neededTime[i];
                }
                else ans += neededTime[i];
            }
        }
        return ans;
    }
}