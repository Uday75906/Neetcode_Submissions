class Solution {
    public int[] findRedundantConnection(int[][] edges) {
       DSU dsu = new DSU(edges.length+1);
       for(int[] e: edges){
        if(!dsu.union(e[0],e[1])){
            return e;
        }
       }

       return new int[2];
    }
    class DSU{
        int[] parent;
        int[] rank;
         
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++){
              parent[i]=i;
              rank[i]=1;
            }
        }
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            
            return parent[i] = find(parent[i]);
        }


        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            
            if (rootI == rootJ) {
                return false; 
            }

            
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootI] = rootJ;
                rank[rootJ]++;
            }
            
            return true;
        }
    }
}
