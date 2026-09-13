class Triplet{
    int stops;
    int node;
    int dis;
    Triplet(int stops, int node, int dis){
        this.stops = stops;
        this.node = node;
        this.dis = dis;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b)->a.stops - b.stops);
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : flights){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        pq.offer(new Triplet(0, src, 0));
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        while(!pq.isEmpty()){
            Triplet popped = pq.poll();
            int stops = popped.stops;
            int node = popped.node;
            int distance = popped.dis;
            for(int[] pair : adj.get(node)){
                int adja = pair[0];
                int cost = pair[1];
                if(stops <= k && distance + cost < dis[adja]){
                    dis[adja] = distance + cost;
                    pq.offer(new Triplet(stops + 1, adja, distance + cost));
                }
            }
        }
        if(dis[dst] == Integer.MAX_VALUE)
            return -1;
        return dis[dst];
    }
}