class Triplet{
    int i;
    int j;
    int time;
    Triplet(int i, int j, int time){
        this.i = i;
        this.j = j;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[] drow = {1, -1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        int[] max = new int[1];
        Queue<Triplet> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.offer(new Triplet(i, j, 0)); 
                }
            }
        }

        bfs(grid, vis, drow, dcol, max, n, m, q); 

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    return -1;
                }
            }
        }
        return max[0]; 
    }

    public void bfs(int[][] grid, int[][] vis, int[] drow, int[] dcol, int[] max, int n, int m, Queue<Triplet> q){
        while(!q.isEmpty()){
            Triplet polled = q.poll();
            int row = polled.i;
            int col = polled.j;
            int time = polled.time;
            max[0] = Math.max(max[0], time);
            for(int k=0; k<4; k++){
                int nrow = row + drow[k];
                int ncol = col + dcol[k];
                if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    q.offer(new Triplet(nrow, ncol, time + 1));
                    vis[nrow][ncol] = time + 1;
                }
            }
        } 
    }
}