class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length())return "";

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char c : t.toCharArray())map.put(c, map.getOrDefault(c, 0)+1);

        int i = 0;
        int required = map.size();
        int formed = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(int j = 0;j<s.length();j++){
            char cr = s.charAt(j);

            window.put(cr, window.getOrDefault(cr, 0)+1);

            if(map.containsKey(cr) && map.get(cr).equals(window.get(cr)))formed++;

            //Shrink :
            while(i <= j && formed == required){
                int curr = j - i + 1;
                if(curr < minLen){
                    minLen = curr;
                    start = i ; 
                }
                //shrink from left : 
                char cl = s.charAt(i);
                window.put(cl, window.getOrDefault(cl, 0)-1);

                if(map.containsKey(cl) && map.get(cl) > window.get(cl))formed--;

                i++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
        
    }
}