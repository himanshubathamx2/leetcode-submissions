class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, new ArrayList<>(), nums, ans);
        return ans;
    }

    public void f(int i, List<Integer> sub, int[] nums, List<List<Integer>> ans){
        if(i == nums.length){
            ans.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        f(i+1, sub, nums, ans);
        sub.remove(sub.size()-1);
        f(i+1, sub, nums, ans);
    }
}