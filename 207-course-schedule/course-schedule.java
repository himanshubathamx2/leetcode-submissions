class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] indeg = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int node : adj.get(i)){
                indeg[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indeg[i] == 0)
                q.offer(i);
        }

        int c = 0;
        while(!q.isEmpty()){
            int popped = q.poll();
            c++;
            for(int adja : adj.get(popped)){
                indeg[adja]--;
                if(indeg[adja] == 0){
                    q.offer(adja);
                }
            }
        }
        return c == numCourses;
    }
}