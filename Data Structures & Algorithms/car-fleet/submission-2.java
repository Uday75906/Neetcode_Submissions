class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       int n = position.length;
       int fleetcount = 1;
       if(n==0) return 0;
       Integer[] indices = new Integer[n];
       for(int i=0; i<n; i++) indices[i]=i;
       Arrays.sort(indices,(a,b) -> Integer.compare(position[b],position[a]));
       double leader = (double)(target-position[indices[0]])/speed[indices[0]];
       for(int i=0; i<n; i++){
        int idx = indices[i];
        double last = (double)(target-position[idx])/speed[idx];
        if(last<=leader){
            continue;
        }
        else{
            fleetcount++;
            leader = last;
        }
       } 
    return fleetcount;
    }
}
