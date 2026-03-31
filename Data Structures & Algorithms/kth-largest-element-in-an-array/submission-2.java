class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> res = new PriorityQueue<>();
        for(int i: nums){
            res.offer(i);

            if(res.size()>k) res.poll();
        }

       return res.peek();
    }
}
