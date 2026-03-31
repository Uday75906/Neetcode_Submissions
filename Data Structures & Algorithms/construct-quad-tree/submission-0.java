/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
       return buildtree(grid,0,0,grid.length); 
    }
    public Node buildtree(int[][] grid, int r, int c, int n){
        if(checksame(grid,r,c,n)){
            return new Node(grid[r][c]==1, true);
        }
        Node root = new Node();
        n = n/2;
        root.topLeft = buildtree(grid,r,c,n);
        root.topRight = buildtree(grid,r,c+n,n);
        root.bottomLeft = buildtree(grid, r+n,c,n);
        root.bottomRight = buildtree(grid,r+n,c+n,n);

        return root;
    }
    public boolean checksame(int[][] grid, int r, int c, int n){
        int firstval = grid[r][c];
        for(int i=r; i<r+n; i++){
            for(int j=c; j<c+n; j++){
                if(firstval!=grid[i][j]) return false;
            }
        }
        return true;
    }
}