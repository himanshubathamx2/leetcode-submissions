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
    
    public void solve(int row, char[][] board, List<List<String>> ans, int n){
        if(row==n){
            List<String> solvedBoard = new ArrayList<>();
            for(char[] horizontal : board){
                String s = new String(horizontal);
                solvedBoard.add(s);
            }
            ans.add(new ArrayList<>(solvedBoard));
            return;
        }
        for(int col=0;col<n;col++){
            if(safe(row, col, board, n)){
                board[row][col]='Q';
                solve(row+1, board, ans, n);
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
        while(row>=0 && col < n){
            if(board[row][col]=='Q')
                return false;
            row--;
            col++;    
        }
        row = dupRow;
        col = dupCol;
        while(row >= 0){
            if(board[row][col]=='Q')
                return false;
            row--;
        }
        return true;
    }
}