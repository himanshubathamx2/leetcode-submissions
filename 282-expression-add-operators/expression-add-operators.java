class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, num, target, 0, 0, 0, "");
        return ans;
    }

    private void backtrack(List<String> ans, String num, int target, int i,
            long currVal, long lastVal, String expr) {

        if (i == num.length()) {
            if (currVal == target) {
                ans.add(expr);
            }
            return;
        }

        for (int ind = i; ind < num.length(); ind++) {

            if (ind > i && num.charAt(i) == '0') {
                break;
            }

            String part = num.substring(i, ind + 1);
            long numValue = Long.parseLong(part);

            if (i == 0) {
                // First number, no operator
                backtrack(ans, num, target, ind + 1,
                        numValue, numValue, part);
            } else {
                // Addition
                backtrack(ans, num, target, ind + 1,
                        currVal + numValue,
                        numValue,
                        expr + "+" + part);

                // Subtraction
                backtrack(ans, num, target, ind + 1,
                        currVal - numValue,
                        -numValue,
                        expr + "-" + part);

                // Multiplication
                backtrack(ans, num, target, ind + 1,
                        currVal - lastVal + (lastVal * numValue),
                        lastVal * numValue,
                        expr + "*" + part);
            }
        }
    }
}