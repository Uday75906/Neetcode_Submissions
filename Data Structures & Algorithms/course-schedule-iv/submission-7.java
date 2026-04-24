class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
      List<List<Integer>> edge = new ArrayList<>();
      for(int i=0; i<numCourses; i++) edge.add(new ArrayList<>());
      for(int[] e: prerequisites){
        edge.get(e[1]).add(e[0]);
      }

      boolean[][] pre = new boolean[numCourses][numCourses];
      for(int i=0; i<numCourses; i++){
        dfs(i,i,edge,pre,new boolean[numCourses]);
      }

      List<Boolean> res = new ArrayList<>();

      for(int[] e: queries){
        if(pre[e[0]][e[1]]) res.add(true);
        else res.add(false);
      }

      return res;
    }
    public void dfs(int start, int end, List<List<Integer>> edge, boolean[][] pre, boolean[] visited){
        if(visited[end]) return;
        (visited[end]) = true;
        
        if(start!=end){
          pre[end][start] = true;
        }
        
        

        for(int i: edge.get(end)){
            dfs(start,i,edge,pre,visited);
        }
        
    }
}