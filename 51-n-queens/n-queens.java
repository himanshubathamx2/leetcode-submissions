class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> ans = new ArrayList<>();
       char[][] board = new char[n][n];
       for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
       }
       solve(0, board, ans , n);
       return ans;
    }
    
    public void solve(int col, char[][] board, List<List<String>> ans, int n){
        if(col==n){
            List<String> list = new ArrayList<>();
            for(char[] row : board){
                String s = new String(row);
                list.add(s);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int row=0;row<n;row++){
            if(safe(row, col, board, n)){
                board[row][col]='Q';
                solve(col+1, board, ans, n);
                board[row][col] ='.';
            }
        }
    }

    public boolean safe(int row, int col, char[][] board, int n){
        int dupRow = row;
        int dupCol = col;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q')
                return false;
            row--;
            col--;    
        }
        row = dupRow;
        col = dupCol;
        while(row<n && col>=0){
            if(board[row][col]=='Q')
                return false;
            row++;
            col--;    
        }
        row = dupRow;
        col = dupCol;
        while(col>=0){
            if(board[row][col]=='Q')
                return false;
            col--;    
        }
        return true;
    }
}