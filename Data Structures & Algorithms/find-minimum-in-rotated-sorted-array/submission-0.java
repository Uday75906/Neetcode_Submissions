class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0) return -1;
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (right+left)/2;
            if(nums[mid]>nums[nums.length-1]) left = mid+1;
            else if(nums[mid]<nums[nums.length-1]) right = mid;
        }
    return nums[left];
    }
}
