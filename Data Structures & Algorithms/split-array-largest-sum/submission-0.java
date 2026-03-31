class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for(int i=0; i< nums.length; i++){
            right += nums[i];
            left  = Math.max(left, nums[i]);

        }
        while(left<right){
            int mid = (left+right)/2;
            int val = partitions(mid, nums);
            if(val<k) right = mid;
            else if(val>k) left = mid+1;
            else{
                right = mid;
            }
        }
    return left;
    }
    public int partitions(int cap, int[] a){
        int p = 1;
        int sum = 0;
        for(int i: a){
            if(sum+i>cap){
                sum = i;
                p++;
            }
            else{
                sum += i;
            }
        }
        return p;
    }
}