class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())map.put(c, map.getOrDefault(c, 0)+1);
        int vo = 0;
        int co = 0;
        for(char c : map.keySet()){
            int freq = map.get(c);
            if(c == 'a' ||c == 'e' ||c == 'i' ||c == 'o' ||c == 'u'){
                vo = Math.max(vo, freq);
            }
            else co = Math.max(co, freq);
        }

        return co+vo;
    }
}