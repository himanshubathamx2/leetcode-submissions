class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, nums, ans);
        return ans;
    }

    public void f(int i, int[] nums, List<List<Integer>> ans){
        if(i == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int j=i; j<nums.length; j++){
            swap(nums, i, j);
            f(i+1, nums, ans);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}