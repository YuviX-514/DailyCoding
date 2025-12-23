class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int a = s1.length();
        int b = s2.length();
        int c = s3.length();

        int minLen = Math.min(a, Math.min(b, c));

        int i= 0;

        while(i < minLen && s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i))i++;

        if(i == 0)return -1;

        return (a-i)+ (b-i)+(c-i);

    }
}