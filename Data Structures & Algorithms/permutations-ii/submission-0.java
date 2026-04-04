class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length], 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> current, int[] nums, boolean[] used, int index ){
        if(current.size()==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        if(index==nums.length) return;
        if(!used[index]){
            current.add(nums[index]);
            used[index] = true;
            backtrack(res, current, nums, used, 0);

            current.remove(current.size()-1);
            used[index] = false;

            while(index+1<nums.length && nums[index]==nums[index+1]){
            index++;
        }
        }

        

        backtrack(res, current, nums, used, index+1);
    }
}