class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i =0;
        int j = 0;
        String ans = "";
        while(i<word1.length() ){
            ans = ans+""+word1.charAt(i);
             i++;
            if(j<word2.length()){
                ans = ans+""+word2.charAt(j);
                 j++;
            }
        }
        ans = ans+word2.substring(j);
        return ans;
    }
}