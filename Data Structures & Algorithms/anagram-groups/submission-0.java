public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for(String s: strs){
            char[] chararr = s.toCharArray();
            Arrays.sort(chararr);
            String sorteds = new String(chararr);
            result.putIfAbsent(sorteds, new ArrayList<>());
            result.get(sorteds).add(s);
        }
        return new ArrayList<>(result.values());
    }
}