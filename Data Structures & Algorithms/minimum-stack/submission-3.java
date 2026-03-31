class MinStack {
      Stack<Integer> res;
      int min = Integer.MAX_VALUE;
    public MinStack() {
     res = new Stack<>();   
    }
    
    public void push(int val) {
        if(val<=min){
          res.push(min);
          min=val;
        }
       res.push(val); 
    }
    
    public void pop() {
        if(res.pop()==min){
            min = res.pop();
        }
      
    }
    
    public int top() {
        return res.peek();
    }
    
    public int getMin() {
       return min; 
    }
}
