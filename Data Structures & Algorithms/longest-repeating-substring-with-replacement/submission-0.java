class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int maxfreq = 0;
        int[] arr = new int[26];
        int i = 0;
        int j = 0;
        while(j<s.length()){
            arr[s.charAt(j)-'A']++;
            maxfreq = Math.max(maxfreq, arr[s.charAt(j)-'A']);
            if(((j-i+1)-maxfreq)>k){
                arr[s.charAt(i)-'A']--;
                i++;
            }
            max = Math.max(max, j-i+1);
            j++;
        }
   return max;
    }
}
