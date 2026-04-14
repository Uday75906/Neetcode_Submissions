class Solution {
    public boolean isAlienSorted(String[] words, String order) {
       int[] map = new int[26];
       for(int i=0; i<order.length(); i++){
           int index = order.charAt(i)-'a';
           map[index] = i;
       }
       for(int i=0; i<words.length-1; i++){
        String w1 = words[i];
        String w2 = words[i+1];
        int a = 0;
        int b = 0;
        while(a<w1.length() && b<w2.length()){
            if(w1.charAt(a)!=w2.charAt(b) && map[w1.charAt(a)-'a']>map[w2.charAt(b)-'a']){
                return false;
            }
            if(w1.charAt(a)!=w2.charAt(b) && map[w1.charAt(a)-'a']<map[w2.charAt(b)-'a']) break;
             
            a++;
            b++;
        }
        if(w2.length()<w1.length() && w1.indexOf(w2)==0){
            return false;
        }
       }
       return true;
    }
}