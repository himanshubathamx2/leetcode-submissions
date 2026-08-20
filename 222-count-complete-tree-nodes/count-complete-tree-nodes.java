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
    public int countNodes(TreeNode root) {
        return f(root);
    }

    public int f(TreeNode root){
        int leftHt = leftHt(root);
        int rightHt = rightHt(root);
        if(leftHt == rightHt)
            return (1 << leftHt) - 1;
        return 1 + f(root.left) + f(root.right);
    }

    public int leftHt(TreeNode root){
        int c = 0;
        while(root != null){
            root = root.left;
            c++;
        }
        return c;
    }

    public int rightHt(TreeNode root){
        int c = 0;
        while(root != null){
            root = root.right;
            c++;
        }
        return c;
    }
}