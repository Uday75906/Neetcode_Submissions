class Solution {
     int majorityElement(int[] nums) {
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int num: nums){
        map.put(num, map.getOrDefault(num, 0)+1);
       }
       int max = 0;
       int majority = 0;
       for(int num: map.keySet()){
           if(map.get(num)>max){
            max = map.get(num);
            majority = num;
           }
       }
       return majority;
    }
}