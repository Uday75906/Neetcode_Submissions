class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        if(nums.length==0) return new int[0];
        int r = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<nums.length; i++){
            if(!dq.isEmpty() && dq.peekFirst()==i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                res[r++] = nums[dq.peekFirst()];
            }
        }
   return res;
    }
}
