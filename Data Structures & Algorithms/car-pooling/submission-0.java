class Solution {
    class car{
        int pass;
        int from;
        int to;
        car(int pass, int from, int to){
            this.pass = pass;
            this.from = from;
            this.to = to;
        }
    }
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<car> first = new PriorityQueue<>((x,y) -> x.from-y.from);
        PriorityQueue<car> second = new PriorityQueue<>((p,q) -> p.to-q.to);
        for(int i=0; i<trips.length; i++){
            first.offer(new car(trips[i][0],trips[i][1],trips[i][2]));
        }

        int dist = 1;
        int cpass = 0;
        while(!first.isEmpty()){
            car  curr = first.poll();
            int currpass = curr.pass;
            int from = curr.from;
            int to = curr.to;
            while(!second.isEmpty() && second.peek().to<=from){
                cpass -= second.poll().pass;
            }

            cpass += currpass;
            if(cpass>capacity) return false;

            second.offer(curr);
        }

        return true;
    }
}