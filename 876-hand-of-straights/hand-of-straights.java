class Solution {
    public boolean isNStraightHand(int[] hand, int gs) {
        Map<Integer, Integer> map = new TreeMap<>();
        int n = hand.length;
        for(int h : hand){
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        while(!map.isEmpty()){
            int min = getMin(map);
            for(int i=1; i<=gs; i++){
                if(!map.containsKey(min))
                    return false;
                int freq = map.get(min);
                freq--;
                if(freq > 0)
                    map.put(min, freq);
                else if(freq == 0)
                    map.remove(min);    
                min++;
            }
        }
        return true;
    }

    public int getMin(Map<Integer, Integer> map){
        for(int n : map.keySet())
            return n;
        return -1;
    }
}