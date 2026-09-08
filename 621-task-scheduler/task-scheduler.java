class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int val : map.values()){
            pq.offer(val);
        }
        int time = 0;
        while(!pq.isEmpty()){
            int cycle = n + 1;
            List<Integer> remain  = new ArrayList<>();
            while(cycle > 0 && !pq.isEmpty()){
                time++;
                cycle--;
                int popped = pq.poll();
                popped--;
                if(popped > 0){
                    remain.add(popped);
                }
            }
            for(int freq : remain)
                pq.offer(freq);
            if(pq.isEmpty())
                break;
            time += cycle;
        }
        return time;
        
    }
}