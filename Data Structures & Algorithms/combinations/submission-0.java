class Solution {
    public List<List<Integer>> combine(int n, int k) {
     List<List<Integer>> res = new ArrayList<>();
     backtrack(res, new ArrayList<Integer>(), n, k);
     return res;   
    }

    public void backtrack(List<List<Integer>> res, List<Integer> current, int remain, int size){
        if(current.size()==size){
            res.add(new ArrayList<>(current));
            return;
        }
        if(remain==0) return;
        current.add(remain);
        backtrack(res,current, remain-1, size);

        current.remove(current.size()-1);
        backtrack(res,current,remain-1,size);
    }
}