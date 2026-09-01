class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] prev = new int[n];
        prev[0] = height[0];
        for(int i=1; i<n; i++){
            prev[i] = Math.max(prev[i-1], height[i]);
        }

        int[] next = new int[n];
        next[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            next[i] = Math.max(next[i+1], height[i]);
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += Math.min(prev[i], next[i]) - height[i];
        }
        return ans;

    }
}