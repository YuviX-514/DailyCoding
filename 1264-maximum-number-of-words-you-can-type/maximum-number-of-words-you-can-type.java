class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for(char c : brokenLetters.toCharArray())set.add(c);
        int count = 0;
        String[] st = text.split(" ");
        boolean flag = false;
        for(String s : st){
            for(char c : s.toCharArray()){
                if(set.contains(c)){
                    flag = true;
                    break;
                }
            }
            if(!flag)count++;
            flag = false;
        }

        return count;
    }
}