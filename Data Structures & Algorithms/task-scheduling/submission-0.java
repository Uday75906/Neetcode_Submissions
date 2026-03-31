class Solution {
    public int leastInterval(char[] tasks, int n) {
       int[] count = new int[26];

       for(char i: tasks)  count[i-'A']++;

       PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
       for(int i: count){
        if(i>0) maxheap.offer(i);
       }

       Queue<int[]> q = new LinkedList<>();
       int time = 0;

       while(!maxheap.isEmpty() || !q.isEmpty()){
        time++;

        if(!maxheap.isEmpty()){
            int remaining = maxheap.poll()-1;
            if(remaining>0){
                q.offer(new int[]{remaining, time+n});
            }        }
       
             if(!q.isEmpty()){
        if(q.peek()[1]==time){
            maxheap.offer(q.poll()[0]);
        }
       }
       }

      
     return time;
    }
}
