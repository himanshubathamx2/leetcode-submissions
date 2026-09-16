class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        f(0, ans, new ArrayList<>(), s);
        return ans;
    }

    public void f(int i, List<List<String>> ans, List<String> sub, String s){
        if(i==s.length()){
            ans.add(new ArrayList<>(sub));
            return;
        }

        for(int ind = i; ind<s.length(); ind++){
            String ss = s.substring(i, ind + 1);
            if(isPalin(ss)){
                sub.add(ss);
                f(ind+1, ans, sub, s);
                sub.remove(sub.size()-1);
            }
        }
    }

     public boolean isPalin(String s){
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}