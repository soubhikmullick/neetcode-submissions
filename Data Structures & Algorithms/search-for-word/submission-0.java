class Solution {
    public boolean exist(char[][] board, String word) {
        int id = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(dfs(board, word, id, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int id, int row, int col) {
        if(id == word.length()) {return true;}
        
        if(row<0 || col<0 || row>=board.length ||  col>=board[0].length 
           || id>word.length() 
           || board[row][col] != word.charAt(id) 
           || board[row][col] == '#') {
            return false;
        }
        
        board[row][col] = '#';
        boolean res = dfs(board, word, id + 1, row + 1, col) ||
                      dfs(board, word, id + 1, row - 1, col) ||
                      dfs(board, word, id + 1, row, col + 1) ||
                      dfs(board, word, id + 1, row, col - 1);
        board[row][col] = word.charAt(id);
        return res;
    }

    
}
