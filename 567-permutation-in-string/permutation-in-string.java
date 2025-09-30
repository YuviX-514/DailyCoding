class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())return false;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray())map.put(c, map.getOrDefault(c, 0)+1);
        for(int i = 0;i<s2.length()-s1.length()+1;i++){
            if(check(s2.substring(i, i+s1.length()), map))return true;
        }
       return false;
    }

    public boolean check(String s, Map<Character, Integer> map){
        Map<Character, Integer> m = new HashMap<>();

        for(char c : s.toCharArray())m.put(c, m.getOrDefault(c, 0)+1);

        return map.equals(m);

    }
}