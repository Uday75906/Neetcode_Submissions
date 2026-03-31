class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> res = new PriorityQueue<>((a,b) -> {
            int distA = a[0]*a[0]+a[1]*a[1];
            int distB = b[0]*b[0]+b[1]*b[1];
            return Integer.compare(distB,distA);
        });

        for(int[] i: points){
            res.offer(i);

            if(res.size()>k){
                res.poll();
            }
        }
        int[][] result = new int[k][2];
        while(k>0){
            result[--k] = res.poll();
        }

        return result;

    }
}
