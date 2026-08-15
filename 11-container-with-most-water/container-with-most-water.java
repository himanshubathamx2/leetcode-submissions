class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxHt = Integer.MIN_VALUE;
        int maxArea = Integer.MIN_VALUE;
        while(left < right){
            if(height[left] > maxHt || height[right] > maxHt){
                maxHt = Math.min(height[left], height[right]);
                maxArea = Math.max(maxArea, maxHt * (right - left));
            }
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}