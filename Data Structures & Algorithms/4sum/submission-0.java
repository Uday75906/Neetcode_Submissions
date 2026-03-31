class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int se = i+1;
            while(se<nums.length-2){
                int th = se+1;
                int la = nums.length-1;
                while(th<la){
                    long sum = (long)nums[i]+nums[se]+nums[th]+nums[la];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[se],nums[th],nums[la]));
                        th++;
                        la--;
                    while(th<la && nums[th]==nums[th-1]) th++;
                    while(th<la && nums[la]==nums[la+1]) la--;
                    }
                    else if(sum>target){
                        la--;
                    }
                    else{
                        th++;
                    }
                    
                }
            int currse = nums[se];
            while(se<nums.length-2 && nums[se]==currse){
                se++;
            }
            }
        }
   return res;
    }
}