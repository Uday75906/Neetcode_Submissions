class Solution {
    public int maxProduct(int[] nums) {
        int maxsofar = nums[0];
        int minsofar = nums[0];
        int res = nums[0];
        for(int i=1; i<nums.length; i++){
            int curr = nums[i];
            if(curr<0){
                int temp = maxsofar;
                maxsofar = minsofar;
                minsofar = temp;
            }

            maxsofar = Math.max(curr, maxsofar*curr);
            minsofar = Math.min(curr, minsofar*curr);

            res = Math.max(maxsofar, res);
        }

        return res;
    }
}
