class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> res= new Stack<>();
       for(String s: tokens){
        if(s.equals("+") || s.equals("*")|| s.equals("/") || s.equals("-")){
            int second = (res.pop());
            int first = (res.pop());
            switch (s) {
        case "+" -> res.push(first+second);
        case "-" -> res.push(first-second);
        case "*" -> res.push(first*second);
        case "/" -> res.push(first/second);
    }
        }
        else{
            res.push(Integer.parseInt(s));
        }
       } 
   return res.pop();
    }
}
