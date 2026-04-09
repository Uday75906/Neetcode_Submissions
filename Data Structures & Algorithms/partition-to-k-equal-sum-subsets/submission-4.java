class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
      int total = 0;
      for(int i: nums) total += i;
      if(total%k!=0) return false;

      int[] sum = new int[k];
      Arrays.sort(nums);
      reverse(nums);
      return backtrack(nums, sum, total/k, 0, k);  
    }
    public boolean backtrack(int[] nums, int[] sum, int target, int index, int partition){
      if(index==nums.length) return true;
      
      for(int i=0; i<sum.length; i++){
        if(sum[i]+nums[index]<=target){
          if(i>0 && sum[i]==sum[i-1]) continue;

          sum[i] += nums[index];
          if(backtrack(nums, sum, target, index+1, partition)) return true;

          sum[i] -= nums[index];

        }
      }
      return false;
    }

    public void reverse(int[] arr){
      int left = 0;
      int right = arr.length-1;
      while(left<right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
      }
    }
}