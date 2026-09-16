class Solution {
    public int countGoodNumbers(long n) {
        long odd = n/2;
        long even = n - odd;
        
        long mod = (int)1e9 + 7;
        long ans = (pow(5, even) * pow(4, odd)) % mod;
        return (int)ans;
    }

    public long pow(long x, long n){
        long ans = 1;
        long mod = (int)1e9 + 7;
        while(n > 0){
            if(n % 2 == 0){
                x = (x*x) % mod;
                n = n/2;
            }else{
                ans = (ans * x) % mod;
                n = n-1;
            }
        }
        return ans;
    }
}