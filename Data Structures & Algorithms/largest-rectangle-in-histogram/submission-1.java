class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> res = new Stack<>();
        int max = 0;
        for(int i=0; i<=heights.length; i++){
            int ce = (i<heights.length)?heights[i]:0;
            while(!res.isEmpty() && ce<heights[res.peek()]){
                int h = heights[res.pop()];
                int w = res.isEmpty()?i:i-res.peek()-1;
                max = Math.max(max, h*w);
            }
            res.push(i);
        }
    return max;
    }
}
