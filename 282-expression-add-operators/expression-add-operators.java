class Solution {

    public List<String> addOperators(String s, int target) {
        List<String> ans = new ArrayList<>();
        dfs(0, "", 0, 0, s, target, ans);
        return ans;
    }

    private void dfs(int i, String path, long resSoFar, long prevNum, String s, int target, List<String> ans) {
        if (i == s.length()) {
            if (resSoFar == target)
                ans.add(path);
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (j > i && s.charAt(i) == '0')
                break; // Skip leading zero number

            long currNum = Long.parseLong(s.substring(i, j + 1));

            if (i == 0) {
                dfs(j + 1, "" + currNum, currNum, currNum, s, target, ans);
                // First num, pick it without adding any operator
            } else {
                // Addition
                dfs(j + 1, path + "+" + currNum, resSoFar + currNum, currNum, s, target, ans);

                // Subtraction
                dfs(j + 1, path + "-" + currNum, resSoFar - currNum, -currNum, s, target, ans);

                // Multiplication
                dfs(j + 1, path + "*" + currNum, resSoFar - prevNum + prevNum * currNum,prevNum * currNum, s, target, ans);
            }
        }
    }
}