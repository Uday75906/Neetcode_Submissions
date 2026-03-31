class Solution {
    public int removeDuplicates(int[] nums) {
      int count = 1;
      int index = 0;
      int last = nums[0];
      for(int i=1; i<nums.length; i++){
          if(nums[i]==nums[index]) continue;
          index++;
          nums[index] = nums[i];
          count++;
      }
      return count;
    }
}