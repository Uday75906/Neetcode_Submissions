class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid.length==0) return;
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0; i<rows; i++){
            for(int  j=0; j<cols; j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] dir: directions){
                int rr = r+dir[0];
                int rc = c+dir[1];
                if(rr>=0 && rc>=0 && rr<rows && rc<cols && grid[rr][rc]==Integer.MAX_VALUE){
                    grid[rr][rc] = grid[r][c]+1;

                    q.offer(new int[]{rr,rc});
                }
            }
        }
    }
}
