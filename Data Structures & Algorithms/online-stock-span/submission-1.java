class StockSpanner {
Stack<int[]> res;
    public StockSpanner() {
       res = new Stack<>(); 
    }
    
    public int next(int price) {
        int span = 1;
        while(!res.isEmpty() && res.peek()[0]<=price){
           span += res.pop()[1];
        }
        res.push(new int[]{price,span});
        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */