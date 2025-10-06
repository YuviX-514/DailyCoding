class Solution {
    public int countSubstrings(String s) {
        int c =0;
        int n = s.length();
        for(int i = 0;i<n;i++){
            c += expand(s, i, i); //odd
            c += expand(s, i, i+1); //even
        }
        return c;
    }
    int expand(String s, int i, int j){
        int c =0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            c++;
            i--;
            j++;
        }
        return c;
    }
}