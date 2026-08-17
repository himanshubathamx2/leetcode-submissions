class Solution {
    public int strStr(String haystack, String needle) {
        return rabin(haystack, needle);
    }

    public int rabin(String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        if(m > n)
            return -1;
        long d = 256;
        long prime = (int)1e9 + 7;
        long h = 1;
        long t = 0;
        long p = 0;
        for(int i=0; i<m-1; i++){
            h = (h * d) % prime;
        }

        for(int i=0; i<m; i++){
            t = (t + d * text.charAt(i)) % prime;
            p = (p + d * pattern.charAt(i)) % prime;
        }

        for(int i=0; i <= n-m; i++){
            boolean flag = true;
            for(int j=0; j<m; j++){
                if(text.charAt(i+j) != pattern.charAt(j))
                    flag = false;
            }
            if(flag){
                return i;
            }

            if(i + m < n){
                t = ((t - h * text.charAt(i)) + d * text.charAt(i + m)) % prime;
            }
           
            if(t < 0)
                t += prime;
        }
        return -1;
    }
}