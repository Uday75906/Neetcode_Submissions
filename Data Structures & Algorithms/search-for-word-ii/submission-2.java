class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(int i =0; i<words.length; i++){
            boolean foundword = false;
           for(int j=0; j<board.length; j++){
               for(int k=0; k<board[0].length; k++){
                  if(board[j][k]==words[i].charAt(0) && check(board, words[i], 0, j, k)){
                    res.add(words[i]);
                    foundword = true;
                    break;
                    }
               }
               if(foundword){
                break;
               }
           }
        }

        return res;
    }
    public boolean check(char[][] board, String s, int index, int row, int col){
        if(index==s.length()){
            return true;
        }
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]!=s.charAt(index)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';
        boolean found = check(board,s,index+1, row-1, col) ||
                        check(board,s,index+1, row+1, col) ||
                        check(board,s,index+1, row, col-1) ||
                        check(board,s,index+1, row, col+1);

        board[row][col] = temp;
        return found;
    }
}
