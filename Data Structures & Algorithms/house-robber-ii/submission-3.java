class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];

        int pre =0, pre1=0;
        for(int i=0; i<nums.length-1; i++){
                int n = nums[i];
                int temp = Math.max(pre, pre1+n);
                pre1 = pre;
                pre = temp;
        }
        int prev1=0, prev2=0;
        for(int i=1; i<nums.length; i++){
                int n= nums[i];
                int temp = Math.max(prev1, prev2+n);
                prev2 = prev1;
                prev1 = temp;

        }

        return Math.max(pre,prev1);
    }
}
