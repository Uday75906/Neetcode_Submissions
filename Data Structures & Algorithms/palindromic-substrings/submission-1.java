class Solution {
    public int countSubstrings(String s) {
        if(s.length()==0) return 0;
        int r = 0;
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            r  = r+(len1+len2);
            
        }
        return r; 
    }

    public int expand(String s, int l, int r){
        int res = 0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
            res++;
        }
        return res;
    }
}
