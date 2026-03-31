class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set =  new HashSet<>();
        int max = 0;
        if(nums.length==0) return 0;
        for(int n:nums){
            set.add(n);
        }
        for(int n: set){
            int length = 0;
            int curr = n;
            while(set.contains(curr)){
                length++;
                curr++;
            }
           max=  Math.max(max, length);
        }
        return max;
    }
}
