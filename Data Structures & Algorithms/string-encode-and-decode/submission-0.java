class Solution {

    public String encode(List<String> strs) {
         String result = "";
         for(String n: strs){
            result = result+n.length()+"#"+n;
         }
         return result;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int hashindex = 0;
        while(i<str.length()){
            hashindex = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i,hashindex));
            i = hashindex+length+1;
            res.add(str.substring(hashindex+1, hashindex+length+1));
        }
        return res;
    }
}
