class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     int left = 1;
     int right = 0;
     for(int i=0; i<piles.length; i++) right = Math.max(right, piles[i]);
     while(left<right){
        int mid = (left+right)/2;
        int time = 0;
        for(int i=0; i<piles.length; i++){
            int hoursSpent = 0;
            if (piles[i] % mid == 0) {
               hoursSpent = piles[i] / mid;
                 } else {
                   hoursSpent = (piles[i] / mid) + 1;
                  }
             time += hoursSpent;
        }
        if(time<=h) right = mid;
        else if(time>h) left = mid+1;
     }   
    return left;
    }
}
