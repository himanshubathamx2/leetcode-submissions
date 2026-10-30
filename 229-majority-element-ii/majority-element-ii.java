class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int ele1 = -1;
        int ele2 = -1;
        int c1 = 0; //2
        int c2 = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(c1 == 0 && ele2 != nums[i]){
                c1++;
                ele1 = nums[i]; 
            }else if(c2 == 0 && ele1 != nums[i]){
                c2++; 
                ele2 = nums[i]; 
            }else if(ele1 == nums[i]){
                c1++;
            }else if(ele2 == nums[i]){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for(int i=0; i<n; i++){
            if(ele1 == nums[i]){
                c1++;
            }else if(ele2 == nums[i]){
                c2++;
            }
        }

        if(c1 > n/3)
            ans.add(ele1);
        if(c2 > n/3)
            ans.add(ele2);
        return ans;    
    }
}