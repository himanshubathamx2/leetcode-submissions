class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] leftRow = new boolean[n];            // row usage
        boolean[] lowerDiagonal = new boolean[n + n];  // row + col
        boolean[] upperDiagonal = new boolean[n + n];  // (n - 1) + (col - row)

        char[][] board = new char[n][n];
        for(int i=0; i<board.length; i++)
            Arrays.fill(board[i], '.');
        solve(0, n, board, ans, leftRow, lowerDiagonal, upperDiagonal);
        return ans;
    }

public void solve(int col, int n, char[][] board, List<List<String>> ans,
                  boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal) {
        if(col == n){
            List<String> list = new ArrayList<>();
            for(char[] row : board){
                String s = new String(row);
                list.add(s);
            }
            ans.add(list);
            return;
        }
        
        for(int row = 0; row < n; row++){
            if (!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[n - 1 + col - row]) {
                board[row][col] = 'Q';
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
        upperDiagonal[n - 1 + col - row] = true;

                solve(col + 1, n, board, ans, leftRow, lowerDiagonal, upperDiagonal);

                board[row][col] = '.';
                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[n - 1 + col - row] = false;
}

        }
    }
}