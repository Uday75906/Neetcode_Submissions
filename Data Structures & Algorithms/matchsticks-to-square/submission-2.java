class Solution {
    public boolean makesquare(int[] matchsticks) {
        int perimeter=0;
        for(int i: matchsticks) perimeter += i;
        if(perimeter%4!=0) return false;
        int[] square = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, square, perimeter/4, 0);
    }
    public boolean backtrack(int[] match, int[] res, int side, int index){
        if(index==match.length) return true;
        
       for(int i=0; i<4; i++){
        if(res[i]+match[index]<=side){
            res[i] += match[index];
            if(backtrack(match, res, side, index+1)) return true;

            res[i] -= match[index];

        }

        
       }
       return false;

    } 

    public void reverse(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}