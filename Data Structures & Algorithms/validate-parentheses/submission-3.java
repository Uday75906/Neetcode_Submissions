class Solution {
    public boolean isValid(String s) {
        Stack<Character> res = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='[' || c=='(' || c=='{') res.push(c);
            else{
                if(res.isEmpty()) return false;
                char top = res.pop();

                if (c == ']' && top != '[') return false;
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        
        if(!res.isEmpty()){
            char c = res.peek();
            if(c=='[' || c=='(' || c=='{') return false;
        }
   return true;
    }
}
