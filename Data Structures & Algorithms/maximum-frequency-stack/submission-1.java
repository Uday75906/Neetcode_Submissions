class FreqStack {
  Map<Integer, Integer> f;
  Map<Integer, Stack<Integer>> s;
  int max = 0;
    public FreqStack() {
        f = new HashMap<>();
        s = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = f.getOrDefault(val,0)+1;
        f.put(val, freq);
        s.computeIfAbsent(freq,k->new Stack<>()).push(val);
        max = Math.max(freq,max);
    }
    
    public int pop() {
       int t =  s.get(max).pop();
       f.put(t, f.get(t)-1);
        if((s.get(max)).isEmpty()) max--;
        return t;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */