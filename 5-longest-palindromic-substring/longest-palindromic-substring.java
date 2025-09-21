class Solution {
    public String longestPalindrome(String s) {
        String longest = "";

        for(int i = 0;i<s.length();i++){

            String oddP = expand(s, i, i);
            if(oddP.length() > longest.length())longest = oddP;

            String evenP = expand(s, i, i+1);
            if(evenP.length() > longest.length())longest = evenP;
        }
        return longest;
    }

    public static String expand(String s, int i, int j){
        
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        return s.substring(i+1 , j);
    }
}