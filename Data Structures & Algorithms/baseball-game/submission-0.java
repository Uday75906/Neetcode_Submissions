class Solution {
    public int calPoints(String[] operations) {
      Stack<Integer> res = new Stack<>();
      int ans = 0;
      for(int i=0; i<operations.length; i++){
        if(operations[i].equals("D")){
            res.push(res.peek()*2);
        }
        else if(operations[i].equals("C")){
            res.pop();
        }
        else if(operations[i].equals("+")){
            Stack<Integer> copy = new Stack<>();
            copy.addAll(res);
            int sum = 0;
            int count = 0;
            while(count<2 && !copy.isEmpty()){
                sum += copy.pop();
                count++;
            }
            res.push(sum);
        }
        else{
            res.push(Integer.parseInt(operations[i]));
        }
      }
      while(!res.isEmpty()){
        ans += res.pop();
      }
   return ans;
    }
}