class MedianFinder {

    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
      min.offer(num);
      max.offer(min.poll());
      if(max.size() > min.size()){
         min.offer(max.poll());
      }
    }
    
    public double findMedian() {
        if(min.size() > max.size()){
            return min.peek();
        }
        return (min.peek() + max.peek()) / (double)2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */