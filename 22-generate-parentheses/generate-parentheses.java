class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        f(0, ans, "", n, 0);
        return ans;
    }

    public void f(int i, List<String> ans, String s, int n, int c){
        if(c < 0)
            return;
        if(i == 2*n){
            if(c == 0)
                ans.add(s);
            return;
        }
    
        f(i+1, ans, s+'(', n, c+1);
        // if(c - 1 >= 0){   
            f(i+1, ans, s+')', n, c-1);
        // }
    }    
}