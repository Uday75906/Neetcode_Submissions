class Solution {
    public int findJudge(int n, int[][] trusts) {
      List<List<Integer>> trust = new ArrayList<>();
      trust.add(new ArrayList<Integer>());
      for(int i=0; i<n; i++){
        trust.add(new ArrayList<Integer>());
      }
      for(int[] i: trusts){
        int u = i[0];
        int v = i[1];
        trust.get(u).add(v);
      }
      for(int i=1; i<=n; i++){
        if(checkJudge(i,trust)){
            return i;
        }
      }
      return -1; 
    }
    public boolean checkJudge(int n, List<List<Integer>> t){
        if(!t.get(n).isEmpty()) return false;
       for(int i=1; i<t.size(); i++){
          if(i==n) continue;
          List<Integer> tr = t.get(i);
          if(!tr.contains(n)) return false;
       }
       return true;
    }
}