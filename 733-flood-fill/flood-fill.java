class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        int original = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        int[][] vis = new int[n][m];

        dfs(sr, sc, image, color, drow, dcol, n, m, original, vis);
        return image;
    }

    public void dfs(int sr, int sc, int[][] image, int color, int[] drow, int[] dcol, int n, int m, int original, int[][] vis){
        vis[sr][sc] = 1;
        image[sr][sc] = color;
        for(int i=0; i<4; i++){
            int nrow = sr + drow[i];
            int ncol = sc + dcol[i];
            if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && 
            image[nrow][ncol] == original && vis[nrow][ncol] == 0){
                dfs(nrow, ncol, image, color, drow, dcol, n, m, original, vis);
            }
        }
    }
}