class Solution {
    public int strStr(String haystack, String needle) {
        // if(haystack.contains(needle))return -1;
        int n = needle.length();
        for(int i = 0;i<haystack.length()-n+1;i++){
            if(needle.equals(haystack.substring(i, i+n)))return i;
        }
        return -1;
    }
}