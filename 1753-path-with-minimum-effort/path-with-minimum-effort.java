class Triplet{
    int i;
    int j;
    int dis;
    Triplet(int i, int j, int dis){
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;  
        int m = heights[0].length;
        int[] drow = {1, -1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        if(n == 1 && m == 1)
            return 0;
        Queue<Triplet> q = new LinkedList<>();
        int[][] dis = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        q.offer(new Triplet(0,0,0));
        dis[0][0] = 0;
        while(!q.isEmpty()){
            Triplet popped = q.poll();
            int i = popped.i;
            int j = popped.j;
            int dist = popped.dis;
            for(int k=0; k<4; k++){
                int nrow = i + drow[k];
                int ncol = j + dcol[k];
                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m){
                    int diff = Math.max(dist, Math.abs(heights[i][j] - heights[nrow][ncol]));
                    if(diff < dis[nrow][ncol]){
                        dis[nrow][ncol] = diff;
                        q.offer(new Triplet(nrow, ncol, diff));
                    }
                }
            }
        }
        return dis[n-1][m-1];
    }
}