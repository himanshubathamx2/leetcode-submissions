/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair{
    TreeNode node;
    int rank;
    Pair(TreeNode node, int rank){
        this.node = node;
        this.rank = rank;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int c=0;
            Pair first = null;
            Pair last = null;
            while(c != size){
                Pair popped = q.poll();
                TreeNode node = popped.node;
                int rank = popped.rank;
                c++;
                if(first == null)
                    first = popped;
                last = popped;    
                if(node.left != null) q.offer(new Pair(node.left, rank*2+1));
                if(node.right != null) q.offer(new Pair(node.right, rank*2 + 2));
            } 
            max = Math.max(max, last.rank - first.rank + 1);    
        }
        return max;
    }
}