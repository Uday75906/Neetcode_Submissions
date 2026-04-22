class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
      List<List<Integer>> res = new ArrayList<>();
      if(heights.length==0) return res;
      
      int rows = heights.length;
      int cols = heights[0].length;
      boolean[][] pacific = new boolean[rows][cols];
      boolean[][] atlantic = new boolean[rows][cols];

      for(int i=0; i<rows; i++){
        dfs(heights,i,0,pacific,heights[i][0]);
        dfs(heights,i,cols-1,atlantic,heights[i][cols-1]);
      }
      for(int i=0; i<cols; i++){
        dfs(heights,0,i,pacific,heights[0][i]);
        dfs(heights,rows-1,i,atlantic,heights[rows-1][i]);
      }
      for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            if(pacific[i][j] && atlantic[i][j]){
                res.add(Arrays.asList(i,j));
            }
        }
      }
      return res;

    }
    public void dfs(int[][] heights,int r, int c,boolean[][] pac, int prev){
        if(r<0 || c<0 || r>=heights.length || c>=heights[0].length || heights[r][c]<prev || pac[r][c]==true){
            return;
        }
        pac[r][c] = true;
        dfs(heights, r+1,c,pac,heights[r][c]);
        dfs(heights, r-1,c,pac,heights[r][c]);
        dfs(heights, r,c+1,pac,heights[r][c]);
        dfs(heights, r,c-1,pac,heights[r][c]);
    }
}
