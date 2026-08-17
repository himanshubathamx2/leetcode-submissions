class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        while(sb.length() < b.length()){
            sb.append(a);
            c++;    
        }
        if(rabin(sb.toString(), b) != -1)
                return c;

        sb.append(a);
        c++;
        if(rabin(sb.toString(), b) != -1)
            return c;
        return -1;
    }

    public int rabin(String text, String pattern){
        int prime = 131;
        int d = 101;
        int h = 1;
        int n = text.length();
        int m = pattern.length();
        if(m > n)
            return -1;
        int t = 0;
        int p = 0;
        for(int i=0; i<m-1; i++){
            h = (h*d) % prime;
        }
        for(int i=0; i<m; i++){
            t = (t*d + text.charAt(i)) % prime;
            p = (p*d + pattern.charAt(i)) % prime;
        }
        for(int i=0; i<=n-m; i++){
            if(t == p){
                boolean flag = true;
                for(int j=0; j<m; j++){
                    if(text.charAt(i+j) != pattern.charAt(j))
                        flag = false;
                }
                if(flag){
                    return i;
                }
            }
            if(i+m < n){
                t = (d *(t - h * text.charAt(i)) + text.charAt(i+m)) % prime;
                if(t < 0)
                    t += prime;
            }
        }
        return -1;
    }
}