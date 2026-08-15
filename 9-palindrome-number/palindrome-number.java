class Solution {
    public boolean isPalindrome(int x) {
      int original =x;
      String palin= "";
      if(x<0)
        return false;
      else if(x==0)
        return true;  
      int d=0;
      int n=x;
      while(n!=0){
        d= n%10;
        n=n/10;
        palin= palin + d; 
      }  
      if(palin.equals(x+""))
        return true;
      else
        return false;  
}}