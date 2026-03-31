class Solution {
    public int lengthOfLongestSubstring(String s) {
      int max = 0;
      Set<Character> unique = new HashSet<>();
      int i = 0;
      int j = 0;
      while(j<s.length()){
        if(!unique.contains(s.charAt(j))){
            unique.add(s.charAt(j));
            max = Math.max(max, unique.size());
            j++;
        }
        else{
            unique.remove(s.charAt(i));
            i++;
        }
      }  
    return max;
    }
}
