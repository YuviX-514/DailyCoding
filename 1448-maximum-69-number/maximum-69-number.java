class Solution {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        int i = 0;
        for(char c : s.toCharArray()){
            if(c == '6'){
                break;
            }
            i++;
        }
        if(i == s.length())return Integer.parseInt(s);
        String st = s.substring(0, i)+"9"+s.substring(i+1);
        // s = s.replaceFirst("6", "9");
        return Integer.parseInt(st);
    }
}