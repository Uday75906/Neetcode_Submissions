class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> res = new PriorityQueue<>(Collections.reverseOrder());
       for(int i: stones) res.offer(i);
       while(!res.isEmpty() && res.size()>1){
        int first = res.poll();
        int second = res.poll();
        if(first==second) continue;
        else if(first>second) res.offer(first-second);
       }

       return (res.size()!=0)?res.peek():0; 
    }
}
