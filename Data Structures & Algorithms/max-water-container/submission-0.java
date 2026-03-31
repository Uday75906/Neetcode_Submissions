class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int st = 0;
        int end = heights.length-1;
        while(st<end){
         area  = Math.max((Math.min(heights[st],heights[end]))*(end-st), area);
         if(heights[st]<heights[end]) st++;
         else{
            end--;
         }
        }
     return area;
    }
}
