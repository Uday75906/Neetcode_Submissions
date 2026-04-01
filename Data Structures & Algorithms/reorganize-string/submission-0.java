class Solution {
    public String reorganizeString(String s) {
     int[] count = new int[26];
     for(char c:s.toCharArray()) count[c-'a']++;
     int maxcount = 0;
     int letter = 0;
     for(int i=0; i<26; i++){
        if(count[i]>maxcount){
            maxcount = count[i];
            letter=i;
        }
     }

     if(maxcount>(s.length()+1)/2) return "";
     char[] res = new char[s.length()];
     int idx = 0;


     while(maxcount-->0){
        res[idx] = (char)(letter+'a');
        idx += 2;
        count[letter]--;
     }

     for(int i=0; i<26; i++){
        while(count[i]>0){
            if(idx>=res.length) idx = 1;
            res[idx] = (char)(i+'a');
            idx += 2;
            count[i]--;
        }
     }

     return String.valueOf(res);
      
    }
}