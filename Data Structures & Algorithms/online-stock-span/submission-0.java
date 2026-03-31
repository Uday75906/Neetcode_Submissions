class StockSpanner {
Stack<Integer> res;
    public StockSpanner() {
       res = new Stack<>(); 
    }
    
    public int next(int price) {
        int span = 1;
        Stack<Integer> copy  = new Stack<>();
        copy.addAll(res);
        while(!copy.isEmpty()){
            if(copy.peek()>price){
                break;
            }
            copy.pop();
            span++;
        }
        res.push(price);
        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */