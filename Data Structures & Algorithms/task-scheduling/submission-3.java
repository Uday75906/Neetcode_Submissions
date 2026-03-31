class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char i: tasks) count[i-'A']++;
        PriorityQueue<Integer> rem = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: count){
            if(i>0) rem.offer(i);
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while(!rem.isEmpty() || !q.isEmpty()){
            time++;
            if(!rem.isEmpty()){
                int remaining = rem.poll()-1;
               if(remaining>0) q.offer(new int[]{remaining, time+n});
            }

            if(!q.isEmpty() && q.peek()[1]==time){
                rem.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
