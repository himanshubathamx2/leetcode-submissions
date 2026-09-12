class Pair{
    int val;
    int index;
    Pair(int val, int index){
        this.val = val;
        this.index = index;
    }
}

class StockSpanner {

    Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek().val <= price){
            span += stack.pop().index;
        }
        stack.push(new Pair(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */