class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums.length - 1, new ArrayList<>(), nums, ans);
        return ans;
    }

    public void f(int i, List<Integer> sub, int[] nums, List<List<Integer>> ans) {
        if (i < 0) {
            ans.add(new ArrayList<>(sub));
            return;
        }

        // Take
        sub.add(nums[i]);
        f(i - 1, sub, nums, ans);

        // Backtrack
        sub.remove(sub.size() - 1);

        // Don't take
        f(i - 1, sub, nums, ans);
    }
}