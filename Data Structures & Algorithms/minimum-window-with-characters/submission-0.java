class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int[] count = new int[128];
        for(int i=0; i<t.length(); i++){
            count[t.charAt(i)]++;
        }
        int right = 0;
        int left = 0;
        int requiredcount = t.length();
        int startindex = 0;
        int minlen = Integer.MAX_VALUE;
        while(right<s.length()){
            if(count[s.charAt(right)]>0){
                requiredcount--;
            }
            
            count[s.charAt(right)]--;

            while(requiredcount==0){
               if(right-left+1<minlen){
                minlen = right-left+1;
                startindex = left;
               }
               char lchar = s.charAt(left);
               count[lchar]++;
               if(count[lchar]>0){
                requiredcount++;
               }
               left++;
        }
        right++;
        }
    return (minlen==Integer.MAX_VALUE)?"":s.substring(startindex, startindex+minlen);    
    }
}
