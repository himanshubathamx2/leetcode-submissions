class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int c = 0;
        int ele = -1;
        for(int i=0; i<n; i++){
            if(c == 0){
                ele = nums[i];
                c++;
            }else if(ele == nums[i]){
                c++;
            }else{
                c--;
            }
        }
        return ele;
    }
}