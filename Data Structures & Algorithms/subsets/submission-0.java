class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0,new ArrayList<Integer>());
      return res;  
    }
    public void backtrack(int[] nums, int index, List<Integer> temp){
      if(index==nums.length){
        res.add(new ArrayList<>(temp));
        return;
      }
      temp.add(nums[index]);
      backtrack(nums,index+1,temp);

      temp.remove(temp.size()-1);
      backtrack(nums,index+1,temp);
    }
}
