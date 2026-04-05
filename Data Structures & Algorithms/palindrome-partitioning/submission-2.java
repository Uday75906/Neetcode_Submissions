class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<String>(), s, 0);

        return res;
    }

    public void backtrack(List<List<String>> res, List<String> current, String s, int start){
        if(start==s.length()){
            res.add(new ArrayList<>(current));
            return;
        }
        if(start>s.length()) return;
        for(int i=start; i<s.length(); i++){
            if(isPalindrome(s,start,i)){
                current.add(s.substring(start,i+1));

                backtrack(res, current, s, i+1);
                current.remove(current.size()-1);
            }
        }
    }

    public boolean isPalindrome(String p, int s, int e){
        int left = s;
        int right = e;
        while(left<right){
            if(p.charAt(left)!=p.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
