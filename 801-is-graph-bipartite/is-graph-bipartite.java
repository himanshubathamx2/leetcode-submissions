class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        Arrays.fill(vis, -1);
        for(int i=0; i<V; i++){
            if(vis[i] == -1){
                if(!dfs(i, 1, graph, vis)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int node, int mark,int[][] graph, int[] vis){
        vis[node] = mark;
        for(int adja : graph[node]){
            if(vis[adja] == -1){
                if(!dfs(adja, 1 - mark, graph, vis)){
                    return false;
                }
            }else if(vis[adja] != -1){
                if(vis[adja] == mark)
                    return false;
            }
        }
        return true;
    }
    
}