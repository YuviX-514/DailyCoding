class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visit[][] = new boolean[m][n];
        for(int i =0;i<m;i++){
            for(int j= 0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board, word, visit, i, j, 0))return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][]board, String word, boolean[][]visit, int i, int j, int idx){
        if(idx == word.length())return true;
        if(i < 0 || i > board.length-1 || j < 0 || j >= board[0].length || visit[i][j] || board[i][j] != word.charAt(idx))return false;

        visit[i][j] = true;

        boolean b = helper(board, word, visit, i-1, j, idx+1) || helper(board, word, visit, i+1, j, idx+1) ||helper(board, word, visit, i, j-1, idx+1) || helper(board, word, visit, i, j+1, idx+1);

        visit[i][j] = false;

        return b;
    }
}