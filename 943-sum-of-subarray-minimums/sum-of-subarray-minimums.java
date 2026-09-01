class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n];
        int mod = (int)(1e9 + 7);
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        int[] nse = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long total = 0;
        for(int i=0; i<n; i++){
            long right = nse[i] - i;
            long left = i - pse[i];

            total = (total + (((left*right)%mod)*arr[i])%mod)%mod;

        }
        return (int)total;
    }
}