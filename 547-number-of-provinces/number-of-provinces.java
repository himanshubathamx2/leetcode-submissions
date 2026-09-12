class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = isConnected.length;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        int[] vis = new int[V];
        int c = 0;
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                bfs(i, vis, adj);
                c++;
            }
        }
        return c;
    }

    public void bfs(int node, int vis[],
            List<List<Integer>> adj) {
                Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = 1;
        while (!q.isEmpty()) {
            int popped = q.poll();
            for (int adja : adj.get(popped)) {
                if (vis[adja] == 0) {
                    q.offer(adja);
                    vis[adja] = 1;
                }
            }
        }
    }

}