class Solution {
    public boolean winnerOfGame(String colors) {
        int a = 0;
        int b = 0;
        int x = 0;
        int y = 0;
        for(char c : colors.toCharArray()){
            if(c == 'A'){
                x++;
                y = 0;
            }
            else{
                y++;
                x = 0;
            }
            if(x >= 3)a++;
            if(y >= 3)b++;
        }
        return a > b;
    }
}