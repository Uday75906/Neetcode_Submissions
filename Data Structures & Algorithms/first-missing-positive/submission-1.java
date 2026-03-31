class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i<n){
          if(nums[i]<=0 || nums[i]>n){
            i++;
            continue;
          }
          int index = nums[i]-1;
          if(nums[i]!=nums[index]){
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
          }
          else{
            i++;
          }
        }
        for(int j=0; j<n; j++){
          if(nums[j]!=j+1){
            return j+1;
          }
        }
        return n+1;
    }
}