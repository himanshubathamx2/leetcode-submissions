class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long nn = Math.abs((long)n);
        while(nn > 0){
            if(nn % 2 == 0){
                x *= x;
                nn /= 2;
            }else{
                ans *= x;
                nn -= 1;
            }
        }
        
        if(n < 0)
            return 1 / ans;
        return ans;
    }
}