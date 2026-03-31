class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length*2];
        int idx = 0;
        for(int i=0; i<=1; i++){
            for(int j=0; j<nums.length; j++){
                arr[idx++] = nums[j];
            }
        }
        return arr;
    }
}