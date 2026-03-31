class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> res = new Stack<>();
        for(int i: asteroids){
          boolean alive = true;
          while(!res.isEmpty() && res.peek()>0 && i<0){
            int top = res.peek();
            if(top<Math.abs(i)){
                res.pop();
            }
            else if(top==Math.abs(i)){
                res.pop();
                alive = false;
                break;
            }
            else{
                alive = false;
                break;
            }
          }
           if(alive){
            res.push(i);
           } 
        }
        int[] result = new int[res.size()];
        for (int j = result.length - 1; j >= 0; j--) {
            result[j] = res.pop();
        }
        
   return result;
    }
}