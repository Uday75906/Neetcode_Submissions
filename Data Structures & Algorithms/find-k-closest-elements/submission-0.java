class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-1;
        while(right-left>=k){
            int distl = Math.abs(arr[left]-x);
            int distr = Math.abs(arr[right]-x);
            if(distl>distr){
                left++;
            }
            else{
                right--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=left; i<=right; i++){
            res.add(arr[i]);
        }
    return res;
    }
}