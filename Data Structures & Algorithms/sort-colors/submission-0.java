class Solution {
    public void sortColors(int[] nums) {
       int[] ch = new int[3];
       for(int num:nums){
        ch[num]++;
       } 
       int i =0;
       for(int j=0; j<ch.length; j++){
        while(ch[j]>0){
            nums[i] = j;
            i++;
            ch[j]--;
        }
       }
    }
}