class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int left = 0;
       int right = 0;
       for(int i: weights){
        left = Math.max(left,i);
        right += i;
       }
       while(left<=right){
        int mid = (left+right)/2;
        int wsum = 0;
        int time = 1;
        for(int i: weights){
            if(wsum + i > mid){
                wsum = i;
                time++;
            }
            else{
                wsum += i;
            }
            
        }
        if(time>days) left = mid+1;
        else if(time<=days) right = mid-1;
       } 
    return left;
    }
}