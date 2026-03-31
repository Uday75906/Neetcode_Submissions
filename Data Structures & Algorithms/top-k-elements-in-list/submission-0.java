class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> count = new HashMap<>();
       for(int num: nums){
        count.put(num, count.getOrDefault(num, 0)+1); 
       }
       List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
       list.sort((a,b) -> b.getValue()-a.getValue());
       int[] n = new int[k];
       for(int i=0; i<k; i++){
        n[i] = list.get(i).getKey();
       }
       return n;











    }
}
