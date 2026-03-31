class Solution {
    public int longestConsecutive(int[] nums) {
        int count = 1;
        int max= 0;
        Arrays.sort(nums);
        if(nums.length==1) return 1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]==nums[i]+1){
                 count++;
                 max = Math.max(max, count);
            }
            else if(nums[i+1]==nums[i]){
                max = Math.max(max, count);
                continue;}
            else{
                count = 1;
            }
        }
        return max;
    }
}
