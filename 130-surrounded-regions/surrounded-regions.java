class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        int[] drow = new int[]{1, -1, 0, 0};
        int[] dcol = new int[]{0, 0, 1, -1};

        //top
        for(int j=0; j<m; j++){
            if(vis[0][j] == 0 && board[0][j] =='O'){
                dfs(0, j, board, drow, dcol, vis);
            }
        }

        //right
        for(int i=1; i<n; i++){
            if(vis[i][m-1] == 0 && board[i][m-1] =='O'){
                dfs(i, m-1, board, drow, dcol, vis);
            }
        }

        //bottom
        for(int j=m-2; j>=0; j--){
            if(vis[n-1][j] == 0 && board[n-1][j] =='O'){
                dfs(n-1, j, board, drow, dcol, vis);
            }
        }

        //left
        for(int i=n-2; i>=0; i--){
            if(vis[i][0] == 0 && board[i][0] =='O'){
                dfs(i, 0, board, drow, dcol, vis);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){ 
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] board, int[] drow, int[] dcol, 
    int[][] vis){
        int n = board.length;
        int m = board[0].length;
        vis[i][j] = 1;
        for(int k=0; k<4; k++){
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
            vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow, ncol, board, drow, dcol, vis);
            }
        }
    }
}