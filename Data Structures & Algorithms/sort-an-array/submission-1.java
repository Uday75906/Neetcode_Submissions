class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length-1);
return nums;
    }
    public void divide(int[] arr, int left, int right){
        int mid = (left+right)/2;
        if(left>=right){
            return;
        }
        divide(arr, left, mid);
        divide(arr, mid+1, right);

        merge(arr, left, mid, right);
    }
    public void merge(int[] arr, int left, int mid, int right){
        int n1 = mid-left+1;
        int n2 = right-mid;
        int[] l = new int[n1];
        int[] r = new int[n2];
        for(int i=0; i<n1; i++){
            l[i] = arr[left+i];
        }
        
        for(int i=0; i<n2; i++){
            r[i] = arr[mid+1+i];
        }
        int i=0;
        int j=0;
        int k=left;
        while(i<n1 && j<n2){
            if(l[i]<=r[j]){
                arr[k] = l[i];
                k++;
                i++;
            }
            else{
                arr[k] = r[j];
                k++;
                j++;
            }
           
        }
 while(i<n1){
                arr[k] = l[i];
                i++;
                k++;
            }
            while(j<n2){
                arr[k] = r[j];
                j++;
                k++;
            }
    }
}