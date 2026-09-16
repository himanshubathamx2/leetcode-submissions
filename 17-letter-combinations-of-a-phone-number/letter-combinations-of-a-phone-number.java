class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        f(0, ans, digits, "");
        return ans;
    }

    public void f(int i, List<String> ans, String digits, String s){
        if(i == digits.length()){
            ans.add(s);
            return;
        }

        int digit = Integer.parseInt(digits.charAt(i)+"");
        if(digit == 2){
            for(char ch='a'; ch <= 'c'; ch++){
                f(i+1, ans, digits, s + ch);
            }
        }
        if(digit == 3){
            for(char ch='d'; ch <= 'f'; ch++){
                f(i+1, ans, digits, s + ch);
            }
        }
        if(digit == 4){
            for(char ch='g'; ch <= 'i'; ch++){
                f(i+1, ans, digits, s + ch);
            }
        }
        if(digit == 5){
            for(char ch='j'; ch <= 'l'; ch++){
                f(i+1, ans, digits, s + ch);
            }
        }
        if(digit == 6){
            for(char ch='m'; ch <= 'o'; ch++){
                f(i+1, ans, digits, s + ch);
            }
        }
        if(digit == 7){
            for(char ch='p'; ch <= 's'; ch++){
                f(i+1, ans, digits, s + ch);
            }
        }
        if(digit == 8){
            for(char ch='t'; ch <= 'v'; ch++){
                f(i+1, ans, digits, s + ch);
            }
        }
        if(digit == 9){
            for(char ch='w'; ch <= 'z'; ch++){
                f(i+1, ans, digits, s + ch);
            }
        }
    }
}