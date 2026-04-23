class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> edge = new ArrayList<>();
       for(int i=0; i<numCourses; i++) edge.add(new ArrayList<Integer>());
       for(int[] e: prerequisites){
        int a = e[0];
        int b = e[1];
        edge.get(a).add(b);
       }

       boolean[] visited = new boolean[numCourses];
       boolean[] inStack = new boolean[numCourses];

       for(int i=0; i<numCourses; i++){
        if(check(i, edge, visited, inStack)){
            return false;
        }
       }
       return true; 
    }
    public boolean check(int a, List<List<Integer>> edge, boolean[] visited, boolean[] inStack){
        if(inStack[a]) return true;
        if(visited[a]) return false;

        visited[a] = true;
        inStack[a] = true;

        for(int i: edge.get(a)){
            if(check(i,edge,visited,inStack)){
                return true;
            }
        }
        inStack[a] = false;
        return false;
    }
}
