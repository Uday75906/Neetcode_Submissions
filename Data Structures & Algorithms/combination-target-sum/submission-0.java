class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums,0,new ArrayList<Integer>(),target);
        return res;
    }
    public void backtrack(int[] nums, int index, List<Integer> current, int target){
       if(index==nums.length) return;
       int sum = calculatesum(current);
       if(sum==target){
        res.add(new ArrayList<>(current));
        return;
       }
       if(sum>target) return;

       current.add(nums[index]);
       backtrack(nums,index,current,target);

       current.remove(current.size()-1);
       backtrack(nums, index+1, current,target);
    }
    public int calculatesum(List<Integer> a){
        int count = 0;
        for(int i=0; i<a.size();i++){
          count += a.get(i);
        }
        return count;
    }
}
