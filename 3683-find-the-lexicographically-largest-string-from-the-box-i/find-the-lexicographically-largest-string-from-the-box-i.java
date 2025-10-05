class Solution {
    public String answerString(String word, int f) {
        int n = word.length();
        if(f == 1)return word;

        String ans = "";
        int k = n-f+1;

        for(int i = 0;i < n;i++){
            String s = word.substring(i, Math.min((i+k), n));
            if(ans.compareTo(s) < 0)ans = s;
        }
        
        return ans;
    }
}