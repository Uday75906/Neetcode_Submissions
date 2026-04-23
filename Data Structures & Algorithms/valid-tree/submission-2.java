class Solution {
    public boolean validTree(int n, int[][] edges) {
      if(edges.length!=n-1) return false;

      List<List<Integer>> edge = new ArrayList<>();
      for(int i=0; i<n; i++) edge.add(new ArrayList<Integer>());
      for(int[] e: edges){
        edge.get(e[0]).add(e[1]);
        edge.get(e[1]).add(e[0]);
      }

      boolean[] visited = new boolean[n];
      if(hascycle(0,-1,edge,visited)) return false;

      for(boolean v: visited){
        if(!v) return false;
      }

      return true;
    }
    public boolean hascycle(int curr, int parent, List<List<Integer>> edge, boolean[] visited){
        visited[curr] = true;

        for(int i: edge.get(curr)){
            if(i==parent) continue;
            if(visited[i]) return true;
            if(hascycle(i,curr,edge,visited));
        }

        return false;
    }
}
