class Solution {
    class pair{
        int count;
        char ch;
        pair(char ch, int count){
            this.count = count;
            this.ch = ch;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
       PriorityQueue<pair> pq = new PriorityQueue<>((x,y) -> y.count-x.count);
       if(a>0) pq.offer(new pair('a',a));
       if(b>0) pq.offer(new pair('b', b));
       if(c>0) pq.offer(new pair('c',c));

       StringBuilder res = new StringBuilder();
       while(!pq.isEmpty()){
        pair first = pq.poll();
        int len = res.length();
        if(len>=2 && res.charAt(len-1)==first.ch && res.charAt(len-2)==first.ch){
            if(pq.isEmpty()) break;
            pair  second = pq.poll();
            res.append(second.ch);
            second.count--;
            if(second.count>0) pq.offer(second);
            pq.offer(first);
        }
        else{
            res.append(first.ch);
            first.count--;
            if(first.count>0) pq.offer(first);
        }
       }
       return res.toString();
    }
}