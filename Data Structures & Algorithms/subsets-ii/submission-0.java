class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> current, int[] nums, int index){
        if(index==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backtrack(res, current, nums, index+1);

        current.remove(current.size()-1);
        while(index+1<nums.length && nums[index]==nums[index+1]){
            index++;
        }
        backtrack(res, current, nums, index+1);
    }
}
