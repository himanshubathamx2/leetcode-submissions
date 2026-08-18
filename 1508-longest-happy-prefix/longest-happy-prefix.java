class Solution {
    public String longestPrefix(String s) {
        long d = 256;
        long prime = (int)1e9 + 7;
        long t = 0;
        long p = 0;
        long h = 1;
        int n = s.length();
        // int c = 0;
        int idx = -1;
        for(int i=0; i < n-1; i++){
            t = (t * d + s.charAt(i)) % prime;
            p = (p + h * s.charAt(n-i-1)) % prime;
            if(t==p)
                idx = i;
            h = (h * d) % prime;
        }
        return s.substring(0, idx + 1);
    }
}