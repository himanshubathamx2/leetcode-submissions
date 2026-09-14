class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, ans, new ArrayList<>(), k, n);
        return ans;
    }

    public void f(int i, List<List<Integer>> ans, List<Integer> sub, int k, int n){
        if(i == k){
            int total = 0;
            for(int num : sub){
                total += num;
            }
            if(total == n)
                ans.add(new ArrayList<>(sub));
            return;
        }

        for(int j=1; j<=9; j++){
            if(sub.size() == 0 || sub.size() > 0 && sub.get(sub.size()-1) < j){
                sub.add(j);
                f(i+1, ans, sub, k, n);
                sub.remove(Integer.valueOf(j));
            }
        }
    }
}