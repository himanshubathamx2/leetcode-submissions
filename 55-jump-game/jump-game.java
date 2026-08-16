class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int far = 0;
        for(int i=0; i<n; i++){
            if(far >= n-1)
                return true;
            if(nums[i] == 0 && far <= i){
                return false;
            }
            far = Math.max(far, i + nums[i]);    
        }
        return true;
    }
}