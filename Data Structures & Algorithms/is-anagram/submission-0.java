class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
       int[] chararr = new int[26];
        for(int i=0; i<s.length(); i++){
            int a = s.charAt(i)-'a';
            chararr[a]++;
        }
        for(int i=0; i<t.length(); i++){
            int a = t.charAt(i)-'a';
            if(chararr[a]>0){
                chararr[a]--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
