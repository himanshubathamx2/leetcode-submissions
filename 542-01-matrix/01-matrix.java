class Pair{
    int row;
    int col;
    int dis;
    Pair(int row, int col, int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q= new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] drow = {-1,  1, 0 , 0};
        int[] dcol = {0 ,  0 , -1 , 1};
        int[][] distM = new int[n][m];
        while(!q.isEmpty()){
            Pair popped = q.poll();
            int row = popped.row;
            int col = popped.col;
            int dis = popped.dis;
            distM[row][col] = dis;
            for(int i=0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    q.offer(new Pair(nrow, ncol, dis+1));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        return distM;
    }
}