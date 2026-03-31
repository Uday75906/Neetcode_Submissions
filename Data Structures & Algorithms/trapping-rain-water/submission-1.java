class Solution {
    public int trap(int[] height) {
      int l = 0;
      int r = height.length-1;
      int lmax = 0;
      int rmax = 0;
      int area = 0;
      while(l<r){
        if(height[l]<=height[r]){
            if(height[l]>=lmax){
               lmax = height[l];
            }
            else{
                area += lmax-height[l];
            }
            l++;
        }
        else{
            if(height[r]>=rmax){
                rmax = height[r];
            }
            else{
                area += rmax-height[r];
            }
            r--;
        }
      }
    return area;
    }
}
