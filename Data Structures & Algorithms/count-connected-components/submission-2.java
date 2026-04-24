class Solution {
    public int countComponents(int n, int[][] edges) {
      List<List<Integer>> edge = new ArrayList<>();
      for(int i=0; i<n; i++) edge.add(new ArrayList<>());
      for(int[] e: edges){
        edge.get(e[0]).add(e[1]);
        edge.get(e[1]).add(e[0]);
      }

      int res = 0;
      boolean[] visited = new boolean[n];
      for(int i=0; i<n; i++){
        if(!visited[i]){
          check(i,edge,visited);
          res++;
        }
      }

      return res;
    }

    public void check(int a, List<List<Integer>> edge, boolean[] visited){
      if(visited[a]) return;
      visited[a] = true;

      for(int i: edge.get(a)){
        check(i,edge,visited);
      }
    }
}
