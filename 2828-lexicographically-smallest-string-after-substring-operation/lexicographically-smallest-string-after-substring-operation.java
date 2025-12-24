class Solution {
    public String smallestString(String s) {
        if (s.isEmpty()) return ""; 
        
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        
        boolean allAs = true;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != 'a') {
                allAs = false;
                break;
            }
        }
        
        if (allAs) {
            sb.setCharAt(n - 1, 'z');
            return sb.toString();
        }
        
        int i = 0;
        while (i < n && s.charAt(i) == 'a') {
            i++;
        }
        while (i < n && s.charAt(i) != 'a') {
            sb.setCharAt(i, (char)(s.charAt(i) - 1));
            i++;
        }
        
        return sb.toString();
    }
}