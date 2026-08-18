/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null)
            return root;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int c = 0;
            while(size != c){
                Node popped = q.poll();
                c++;
                if(c == size) 
                    popped.next = null;
                else
                    popped.next = q.peek();    
                if(popped.left != null) q.offer(popped.left);
                if(popped.right != null) q.offer(popped.right);
            }
        }
        return root;
    }
}