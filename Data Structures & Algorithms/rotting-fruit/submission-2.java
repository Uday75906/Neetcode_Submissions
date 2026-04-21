class Solution {
    public int orangesRotting(int[][] grid) {
       if(grid.length==0) return -1;
       Queue<int[]> q = new LinkedList<>();
       int rows = grid.length;
       int cols = grid[0].length;
       for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            if(grid[i][j]==2){
                q.offer(new int[]{i,j});
            }
        }
       }
       int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
       int time = 0;
       while(!q.isEmpty()){
        int size = q.size();
        boolean rotted = false;
        for(int i=0; i<size; i++){
         int[] curr = q.poll();
         int r = curr[0];
         int c = curr[1];
         for(int[] dir: directions){
            int rr = r+dir[0];
            int rc = c+dir[1];
            if(rr>=0 && rc>=0 && rr<rows && rc<cols && grid[rr][rc]==1){
                grid[rr][rc] = 2;
                q.offer(new int[]{rr,rc});
                rotted = true;
            }
         }

        }
        if(rotted) time++;
    
       }

       for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            if(grid[i][j]==1){
                return -1;
            }
          }
        }

        return time;
    }
}
