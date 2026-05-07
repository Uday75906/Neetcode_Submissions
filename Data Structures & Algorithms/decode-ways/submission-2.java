class Solution {
    public int numDecodings(String s) {
     int dp[] = new int[s.length()+1];
     dp[0] = 1;
     if(s.charAt(0)=='0') dp[1] = 0;
     else dp[1] = 1;
     for(int i=2; i<dp.length; i++){
        int one = Integer.parseInt(s.substring(i-1,i));
        if(one>0){
            dp[i]+=dp[i-1];
        }
        int two = Integer.parseInt(s.substring(i-2,i));
        if(two>9 && two<27){
            dp[i]+=dp[i-2];
        }
     }

     return dp[dp.length-1];   
    }
}
