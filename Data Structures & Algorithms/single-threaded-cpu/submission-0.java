class Solution {
    public int[] getOrder(int[][] tasks) {
      int n = tasks.length;
      int[][] arr = new int[n][3];
      for(int i=0; i<n; i++){
        arr[i][1] = tasks[i][0];
        arr[i][2] = tasks[i][1];
        arr[i][0] = i;
      }

      Arrays.sort(arr, (a,b) -> a[1]-b[1]);

      PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
        if(a[2]!=b[2]){
            return a[2]-b[2];
        }

        return a[0]-b[0];
      });
     
      int[] res = new int[n];
      int residx = 0;
      int idx = 0;
      int currenttime = 0;
      while(residx<n){
        if(q.isEmpty() && currenttime<arr[idx][1]){
            currenttime = arr[idx][1];
        }

        while(idx<n && currenttime>=arr[idx][1]){
            q.offer(arr[idx]);
            idx++;
        }

        int[] best = q.poll();
        res[residx++] = best[0];
        currenttime += best[2];
      }
      return res; 
    }
}