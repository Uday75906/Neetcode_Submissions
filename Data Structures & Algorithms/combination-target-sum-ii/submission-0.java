class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), candidates,target,0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> current, int[] nums, int remain, int index){
       
        if(remain==0) {
             res.add(new ArrayList<>(current));
             return;
        }
        if(index==nums.length || nums[index]>remain) return;

        

        current.add(nums[index]);
        backtrack(res,current,nums,remain-nums[index],index+1);

        current.remove(current.size()-1);

        while(index+1<nums.length && nums[index]==nums[index+1]){
            index++;
        }
        backtrack(res, current, nums, remain,index+1);
    }
}
