class Solution {
    public String decodeString(String sp) {
      Stack<StringBuilder> f = new Stack<>();
      Stack<Integer> s = new Stack<>();
      StringBuilder r = new StringBuilder();
      int k=0;
      for(char j: sp.toCharArray()){
        if(Character.isDigit(j)){
            k = k*10+(j-'0');
        }
        else if(Character.isLetter(j)){
            r.append(j);
        }
        else if(j=='['){
            s.push(k);
            f.push(r);
            k = 0;
            r = new StringBuilder();
        }
        else{
            
            int count = s.pop();
            StringBuilder t = new StringBuilder(r);
            r = f.pop();
            while(count-->0){
               r.append(t);
            }
        }
      }
    return r.toString();
    }
}