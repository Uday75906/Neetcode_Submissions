class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      Boolean[] memo = new Boolean[s.length()];
      return backtrack(s,wordDict, 0, memo);  
    }
    public boolean backtrack(String s, List<String> dict, int index, Boolean[] memo){
        if(index==s.length()){
            return true;
        }
        if(memo[index]!=null){
            return memo[index];
        }

        for(String word: dict){
            if(s.startsWith(word, index)){
                if(backtrack(s,dict, index+word.length(), memo)){
                    return memo[index] = true;
                }
            }
        }

        return memo[index] = false;
    }
}
