class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = s1.length();
        while(i+j <= s2.length()){
            String s = s2.substring(i, i+j);
            if(check(s, s1))list.add(i);
            i++;
        }
        return list;
    }

    public boolean check(String s1, String s2){
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(char c : s1.toCharArray())freq1[c-'a']++;
        for(char c : s2.toCharArray())freq2[c-'a']++;

        for(int i = 0;i<26;i++){
            if(freq1[i] != freq2[i])return false;
        }
        return true;
    }
}