class Solution {
    public int[] dailyTemperatures(int[] temp) {
      Stack<Integer> res = new Stack<>();
      int[] r = new int[temp.length];
      for(int i=0; i<temp.length; i++){
        while(!res.isEmpty() && temp[res.peek()]<temp[i]){
            r[res.peek()] = i-res.peek();
            res.pop();
        }
        res.push(i);
      }
   return r;
    }
}
