class Solution {
    public String shortestPalindrome(String s) {
        int longestIndx = longest(s);
        System.out.println(longestIndx);
        String sub = s.substring(longestIndx + 1, s.length());
        System.out.println(sub);
        return new StringBuilder().append(sub).reverse().append(s).toString();
    }

    public int longest(String s){
        int n = s.length();
        long h = 1;
        long d = 256;
        long prime = (int)1e9 + 7;
        long t = 0;
        long p = 0;
        int longest = -1;
        for(int i=0; i<n; i++){
            t = (t * d + s.charAt(i)) % prime;
            p = (h * s.charAt(i) + p) % prime;
            if(t == p)
                longest = i;
            h = (h * d) % prime;
        }
        return longest;
    }
}