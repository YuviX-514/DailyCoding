class Solution {
    int c = 0;
    String ans = "";
    public String getHappyString(int n, int k) {
        
        fn(n, k, new StringBuilder());
        return ans;
        
    }

    void fn(int n, int k, StringBuilder sb){
        if(sb.length() == n){
            c++;
            if(c == k)ans = sb.toString();

            return;
        }
        for(char ch = 'a' ; ch < 'd';ch++){
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == ch)continue;

            sb.append(ch);
            fn(n, k, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}