class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int l = 0;
        for(char ch : num.toCharArray()){
            Integer digit = Integer.parseInt(ch+"");
            if(stack.isEmpty()){
                stack.push(digit);
                continue;
            } 
            if(!stack.isEmpty() && stack.peek() < digit){
                stack.push(digit);
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > digit){ // l=2  //st = 12
                if(l < k){
                    stack.pop();
                    l++;
                }else{
                    break;
                }
            }
            stack.push(digit);
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty() && l < k){
            stack.pop();
            l++;
        }
          
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb.reverse();
        while(sb.length() > 0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0)
            return "0";
        return sb.toString();
    }
}