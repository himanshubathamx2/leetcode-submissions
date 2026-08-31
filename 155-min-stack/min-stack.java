class MinStack {

    Stack<Long> stack;
    Long min;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int value) {
        Long val = (long)value;
        if(stack.isEmpty()){
            stack.push(val);
            min = val;
            return;
        }
        if(val < min){
            stack.push(2 * val - min);
            min =  val;
        }else{
            stack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        Long val = stack.pop();
        if(val < min){
            min = 2 * min - val;
        }
    }
    
    public int top() {
        Long val = stack.peek();
        if(val < min){
            return min.intValue();
        }
        return val.intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */