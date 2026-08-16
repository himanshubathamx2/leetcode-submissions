class Pair{
    int row;
    int col ;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m =board[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int j=0;j<m;j++){
            if(board[0][j] == 1){
               q.offer(new Pair(0, j)); 
               vis[0][j] = 1;    
            }  
        }
        for(int j=0;j<m;j++){
            if(board[n-1][j] == 1){
               q.offer(new Pair(n-1, j));
               vis[n-1][j] = 1;     
            }  
        }
        for(int i=0;i<n;i++){
            if(board[i][0] == 1){
               q.offer(new Pair(i, 0));     
               vis[i][0] = 1;
            }  
        }
        for(int i=0;i<n;i++){
            if(board[i][m-1] == 1){
               q.offer(new Pair(i, m-1));  
               vis[i][m-1] = 1;   
            }  
        }
        int[] drow = {-1 , 1, 0 , 0 };
        int[] dcol = {0  , 0 , 1,  -1};
         while(!q.isEmpty()){
            Pair popped = q.poll();
            int row = popped.row;
            int col = popped.col;
            for(int i=0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]==1){
                    q.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}