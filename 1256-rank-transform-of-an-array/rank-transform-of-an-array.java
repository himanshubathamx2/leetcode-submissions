class Pair{
    int val;
    int index;
    Pair(int val, int index){
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int rank = 0;
        int prev = Integer.MIN_VALUE;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            pq.offer(new Pair(arr[i], i));
        }

        while(!pq.isEmpty()){
            Pair popped = pq.poll();
            int val = popped.val;
            int index = popped.index;
            if(prev == val){
                ans[index] = rank;    
            }else{
                ans[index] = ++rank;
                prev = val;
            }
        }
        return ans;
    }
}