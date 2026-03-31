class Solution {
    public int search(int[] nums, int target) {
       if(nums.length==0) return -1;
       int left = 0;
       int right = nums.length-1;
       
       while(left<=right){
        int mid = (left + right)/2;
        if(nums[mid]==target) return mid;
        if(target>=nums[0]){
        if(nums[mid]>target || nums[mid]<nums[0]) right = mid-1;
        else left = mid+1;
        }
        else{
        if(nums[mid]<target || nums[mid]>=nums[0]) left = mid+1;
        else right = mid-1;
        }
       } 
    return -1;
    }
}
