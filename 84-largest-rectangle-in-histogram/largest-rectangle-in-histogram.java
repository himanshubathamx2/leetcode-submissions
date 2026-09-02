class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        nseFunc(heights, nse);
        pseFunc(heights, pse);
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max ,(nse[i] - pse[i] - 1)* heights[i]);
        } 
        return max;
    }

    private void nseFunc(int[] arr, int[] nse) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    private void pseFunc(int[] arr, int[] psee) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }
}