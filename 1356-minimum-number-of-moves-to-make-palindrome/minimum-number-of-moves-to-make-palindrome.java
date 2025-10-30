class Solution {
    public int minMovesToMakePalindrome(String str) {
        int n = str.length();
        int i=0;
        int j=n-1;
        int ans = 0;
        StringBuilder s = new StringBuilder(str);
        while(i < j){
            int cost1 = Integer.MAX_VALUE;
            int cost2 = Integer.MAX_VALUE;

            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                //choice 1 : left ka pair dhundo ;(right side s dhundna search kro )
                int right = j - 1;
                while(i < right && s.charAt(i) != s.charAt(right))right--;

                if(right != i)cost1 = j - right;

                //choice 2 : right ka pair dhundo ; (left side s dhundna shuru krte h )
                int left = i + 1;
                while(left < j && s.charAt(left) != s.charAt(j))left++;

                if(left != i)cost2 = left - i;

                if(cost1 < cost2){
                    char temp = s.charAt(right);
                    for(int k = right;k < j;k++)s.setCharAt(k, s.charAt(k+1));
                    s.setCharAt(j, temp);
                    
                    ans += cost1;
                }
                else {
                    char temp = s.charAt(left);
                    for(int k = left;k > i;k--)s.setCharAt(k, s.charAt(k-1));
                    s.setCharAt(i, temp);

                    ans += cost2;
                } 
                i++;
                j--;
            }
        }
        return ans;
    }
}