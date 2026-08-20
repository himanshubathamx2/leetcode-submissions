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
class Solution {
    public boolean isValidBST(TreeNode root) {
        //c0 count, c1 prev,c2 boolean
        int[] c = new int[2];
        if(!f(root, c))
            return false;
        return true;    
    }

    public boolean f(TreeNode root, int[] c){
        if(root == null)
            return true;
        if(!f(root.left, c))
            return false;

        c[0]++;
        if(c[0] == 1){
            c[1] = root.val;
        }else{
            if(c[1] >= root.val){
                return false;
            }
            c[1] = root.val;    
        }

        if(!f(root.right, c)) 
            return false;   
        return true;
    }
}