/**
 * // This is MountainArray's API interface.
  * // You should not implement it, or speculate about its implementation
   * interface MountainArray {
    *     public int get(int index) {}
     *     public int length() {}
      * }
       */
        
        class Solution {
            public int findInMountainArray(int target, MountainArray mountainarr) {
                    int peak = peek(mountainarr);
                            int left = index(mountainarr, target, true, 0, peak);
                                    if(left!=-1) return left;

                                            return index(mountainarr, target, false, peak+1, mountainarr.length()-1);
                                                }
                                                    public int peek(MountainArray arr){
                                                            int left=0;
                                                                    int right=arr.length()-1;
                                                                            while(left<right){
                                                                                        int mid = (left+right)/2;
                                                                                                    if(arr.get(mid)<arr.get(mid+1)){
                                                                                                                  left=mid+1;  
                                                                                                                              }
                                                                                                                                          else{
                                                                                                                                                          right=mid;
                                                                                                                                                                      }
                                                                                                                                                                              }
                                                                                                                                                                                      return left;
                                                                                                                                                                                          }
                                                                                                                                                                                              public int index(MountainArray arr, int target, boolean asc, int l, int r){
                                                                                                                                                                                                     int left = l;
                                                                                                                                                                                                            int right = r;
                                                                                                                                                                                                                    while(left<=right){
                                                                                                                                                                                                                                int mid = (left+right)/2;
                                                                                                                                                                                                                                            if(arr.get(mid)==target) return mid;
                                                                                                                                                                                                                                                        if(asc){
                                                                                                                                                                                                                                                                        if(arr.get(mid)>target) right = mid-1;
                                                                                                                                                                                                                                                                                        else left = mid+1;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                else{
                                                                                                                                                                                                                                                                                                                                if(arr.get(mid)>target) left = mid+1;
                                                                                                                                                                                                                                                                                                                                                else right = mid-1;
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                            return -1;
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                }