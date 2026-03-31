class Solution {
    public boolean checkInclusion(String s1, String s2) {
      int[] s1c = new int[26];
      int[] s2c = new int[26];
      if(s1.length()>s2.length()) return false;
      for(int i=0; i<s1.length(); i++){
        s1c[s1.charAt(i)-'a']++;
        s2c[s2.charAt(i)-'a']++;
      }
      for(int i=0; i<s2.length()-s1.length(); i++){
        if(matches(s1c,s2c)) return true;
        s2c[s2.charAt(i)-'a']--;
        s2c[s2.charAt(i+s1.length())-'a']++;
      }       
    return matches(s1c,s2c);
    }
    public boolean matches(int[] s, int[] a){
        for(int i=0; i<s.length; i++){
            if(s[i]!=a[i]) return false;
        }
        return true;
    }
}
