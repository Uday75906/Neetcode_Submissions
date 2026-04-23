class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<List<Integer>> edge = new ArrayList<>();
       for(int i=0; i<numCourses; i++) edge.add(new ArrayList<Integer>());
       for(int[] i: prerequisites){
        edge.get(i[0]).add(i[1]);
       }

       boolean[] visited = new boolean[numCourses];
       boolean[] instack = new boolean[numCourses];
       List<Integer> res = new ArrayList<>();
       for(int i=0; i<numCourses; i++){
        if(check(i,edge,visited,instack, res)){
            return new int[0];
        }
       }

       int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            result[i] = res.get(i);
        }
        return result; 
    }
    public boolean check(int a, List<List<Integer>> edge, boolean[] visited, boolean[] instack, List<Integer> res){
        if(instack[a]) return true;
        if(visited[a]) return false;

        visited[a] = true;
        instack[a] = true;

        for(int i: edge.get(a)){
            if(check(i,edge, visited, instack, res)){
                return true;
            }
        }

        instack[a] = false;
        res.add(a);
        return false;
    }
}
