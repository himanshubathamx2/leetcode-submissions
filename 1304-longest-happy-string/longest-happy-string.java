class Pair{
    int freq;
    int ch;
    Pair(int freq, int ch){
        this.freq = freq;
        this.ch = ch;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);
        if(a > 0) pq.offer(new Pair(a, 'a'));
        if(b > 0) pq.offer(new Pair(b, 'b'));
        if(c > 0) pq.offer(new Pair(c, 'c'));
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair first = pq.poll();
            if(sb.length()-2 >=0 && sb.charAt(sb.length()-1) == (char)first.ch && sb.charAt(sb.length()-2) == (char)first.ch){
                if(pq.isEmpty())
                    return sb.toString();
                Pair second = pq.poll();
                int freq = second.freq;
                sb.append((char)second.ch);
                --freq;
                if(freq > 0){
                    pq.offer(new Pair(freq, second.ch));
                } 
                pq.offer(first);    
            }else{
                sb.append((char)first.ch);
                int freq = first.freq;
                freq--;
                if(freq > 0){
                    pq.offer(new Pair(freq, first.ch));
                } 
            }
        }
        return sb.toString();
    }
}