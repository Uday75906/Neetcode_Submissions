class MedianFinder {
    PriorityQueue<Double> left;
    PriorityQueue<Double> right;
    public MedianFinder() {
        left = new PriorityQueue<>((a,b) -> Double.compare(b,a));
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        Double in = (double)num;
        if(left.isEmpty()){
         left.offer(in);
         return;
        }
        if(in<=left.peek())
          left.offer(in);

        else
         right.offer(in);

        if(left.size()>right.size()+1){
            right.offer(left.poll());
        }
        else if(right.size()>left.size()+1){
            left.offer(right.poll());
        }

    }
    
    public double findMedian() {
        if((left.size()+right.size())%2==0){
            return (left.peek()+right.peek())/2;
        }
        return (left.size()>right.size())?left.peek():right.peek();
    }
}
