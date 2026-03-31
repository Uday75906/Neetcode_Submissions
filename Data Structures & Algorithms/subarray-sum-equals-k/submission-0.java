class Solution {
    public int subarraySum(int[] nums, int k) {
      int count =0;
      int currsum =0;
      Map<Integer, Integer> prefixsum = new HashMap<>();
      prefixsum.put(0,1);
      for(int num: nums){
        currsum += num;
        int diff = currsum-k;
        count += prefixsum.getOrDefault(diff, 0);
        prefixsum.put(currsum, prefixsum.getOrDefault(currsum,0)+1);
      }
      return count;
    }
}