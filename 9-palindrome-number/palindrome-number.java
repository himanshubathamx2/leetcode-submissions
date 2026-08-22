class Solution {
    public boolean isPalindrome(int x) {
        int back = 0;
        int orignal = x;
        while(x > 0){
            int d = x % 10;
            x = x / 10;
            back = back * 10 + d;
        }
        return back == orignal;
    }
}
