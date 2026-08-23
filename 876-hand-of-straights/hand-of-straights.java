class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
        }
        while(map.size() > 0){
            // int curr = map.entrySet().iterator().next().getKey();
            int curr = minKey(map);
            for(int i=0;i<groupSize;i++){
                int card = curr + i;
                if(!map.containsKey(card))
                    return false;
                int val = map.get(card);
                val--;
                if(val > 0)
                    map.put(card, val);
                if(val == 0)
                    map.remove(card);            
            }
        }
        return true;
    }

    public int minKey(TreeMap<Integer, Integer> map){
        for(int n : map.keySet()){
            return n;
        } 
        return -1;   
    }
}