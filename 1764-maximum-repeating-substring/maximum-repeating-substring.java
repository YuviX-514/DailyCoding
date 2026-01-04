class Solution {
    public int maxRepeating(String sequence, String word) {
        int k = word.length();
        int n = sequence.length();
        int ans = 0;
        for(int i=0;i<n-k+1;i++){
            int c = 0;
            int j = i;
            while(j + k <= n && sequence.substring(j, j+k).equals(word)){
                c++;
                j = j + k;
            }
            ans = Math.max(ans, c);
        }
        return ans;
    }
}