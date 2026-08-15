class Triplet{
    int i;
    int j ;
    int time ;
     Triplet(int i, int j , int time){
        this.i = i;
        this.j = j;
        this.time = time;
     }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Triplet> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Triplet(i,j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int max = 0;
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        while(!q.isEmpty()){
            Triplet popped = q.poll();
            int row = popped.i;
            int col = popped.j;
            int time = popped.time;
            max = Math.max(max, time);
            for(int i=0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >=0 && nrow<n && ncol >=0 && ncol<m  && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.offer(new Triplet(nrow, ncol, time + 1));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0)
                    return -1;
            }
        }
        return max;
    }
}