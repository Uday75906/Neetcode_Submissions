class Solution {
    public int totalNQueens(int n) {
      char[][] board = new char[n][n];
      for(char[] c: board) Arrays.fill(c, '.');
      List<List<String>> res = new ArrayList<>();
      backtrack(board, res, 0, n);
      return res.size();
    }
    public void backtrack(char[][] board, List<List<String>> res, int row, int n){
      if(row==n){
        res.add(construct(board));
        return;
      }

      for(int col = 0; col<n; col++){
        if(isSafe(row, col, board)){
          board[row][col] = 'Q';
          backtrack(board, res, row+1, n);
          board[row][col] = '.';
        }
      }
    }
    public boolean isSafe(int row, int col, char[][] board){
      for(int i=0; i<board.length; i++){
        if(board[i][col]=='Q') return false;
      }
      for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
        if(board[i][j]=='Q') return false;
      }
      for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
        if(board[i][j]=='Q') return false;
      }
      return true;
    }
    public List<String> construct(char[][] board){
      List<String> res = new ArrayList<>();
      for(char[] c: board) res.add(new String(c));
      return res;
    }
}