class Node{
    Node links[] = new Node[26];
    boolean flag = false;
    public boolean contains(char ch){
        return links[ch-'a'] != null;
    }
    public void put(char ch, Node node){
        links[ch-'a'] = node;
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public boolean isEnd(){
        return flag;
    }
    public void setEnd(){
        flag = true;
    }
}


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for(String word : words){
            insert(word, root);
        }

        Set<String> set = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        int[] drow = {1, -1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int[][] vis = new int[n][m];
                dfs(i, j, drow, dcol, vis, board, set, "", root, n, m);
            }
        }
        List<String> ans = new ArrayList<>(set);
        return ans;
    }

    public void dfs(int i, int j, int[] drow, int[] dcol, int[][] vis, 
    char[][] board,  Set<String> set, String s, Node root, int n, int m){
        char ch = board[i][j];
        if(root.contains(ch)){
            s += ch;
            root = root.get(ch);
            if(root.isEnd()){
                set.add(s);
            }
        }else{
            return;
        }
        
        vis[i][j] = 1;
        for(int k = 0; k<4; k++){
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if(nrow >=0 && nrow < n && ncol >=0 && ncol < m &&
            vis[nrow][ncol]==0){
                dfs(nrow, ncol, drow, dcol, vis, board, set, s, root, n, m);
            }
        }
        vis[i][j] = 0;
    }

    public void insert(String word, Node root){
        Node node = root;
        for(char ch : word.toCharArray()){
            if(!node.contains(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
}