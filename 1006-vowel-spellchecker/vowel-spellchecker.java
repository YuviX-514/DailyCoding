class Solution {
    public String[] spellchecker(String[] wordList, String[] queries) {
        Set<String> set = new HashSet<>(Arrays.asList(wordList));
        Map<String, String> lowerMap = new HashMap<>();
        for (String w : wordList) {
            String lw = w.toLowerCase();
            if (!lowerMap.containsKey(lw)) {
                lowerMap.put(lw, w);
            }
        }

        String[] ans = new String[queries.length];
        int i = 0;
        for(String s : queries){
            if(set.contains(s)){
                ans[i++] = s;
                continue;
            }
            String str = s.toLowerCase();
            if(lowerMap.containsKey(str)){
                ans[i++] = lowerMap.get(str);
                continue;
            }

            Pair p = canChange(wordList, str);
            if (p.flag) ans[i] = p.s;
            else ans[i] = "";
            i++;
        }
        return ans;
    }
    Set<Character> vowel = new HashSet<>(Arrays.asList('a','e','i','o','u'));
    class Pair{
        boolean flag = true;
        String s = "";
        Pair(boolean flag, String s){
            this.flag = flag;
            this.s = s;
        }
    }

    public Pair canChange(String[] wordList, String st) {
    for (String s : wordList) {
        if (s.length() != st.length()) continue;

        boolean ok = true;
        for (int i = 0; i < s.length(); i++) {
            char c1 = Character.toLowerCase(s.charAt(i));
            char c2 = Character.toLowerCase(st.charAt(i));

            if (c1 == c2) continue; 
            else if (vowel.contains(c1) && vowel.contains(c2)) continue; 
            else {
                ok = false;
                break;
            }
        }
        if (ok) return new Pair(true, s); 
    }
    return new Pair(false, ""); 
}

}