class Solution {
    public int subsetXORSum(int[] nums) {
       return calculate(nums,0,0); 
    }
    public int calculate(int[] nums, int total, int index){
       if(index==nums.length) return total;
       int include = calculate(nums,total^nums[index],index+1);
       int exclude = calculate(nums,total,index+1);
       return include+exclude;
    }
}