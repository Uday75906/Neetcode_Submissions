class Solution {
    public void solve(char[][] board) {
     if(board.length==0) return;
     int rows = board.length;
     int cols = board[0].length;
     boolean[][] check = new boolean[rows][cols];
     for(int i=0; i<rows; i++){
        dfs(board, i,0,check);
        dfs(board, i, cols-1, check);
     }

     for(int i=0; i<cols; i++){
        dfs(board, 0,i,check);
        dfs(board, rows-1, i, check);
     }

     for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            if(!check[i][j]){
                board[i][j] = 'X';
            }
        }
     }


    }
    public void dfs(char[][] board, int r, int c, boolean[][] check){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!='O' || check[r][c]){
            return;
        }
        check[r][c] = true;
        dfs(board,r+1,c,check);
        dfs(board,r-1,c,check);
        dfs(board,r,c-1,check);
        dfs(board,r,c+1,check);
    }
}
