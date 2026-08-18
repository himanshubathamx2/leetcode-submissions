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
    public boolean checkTree(TreeNode root) {
        return check(root);
    }

    public boolean check(TreeNode root){
        if(root == null){
            return true;
        }
        int data = 0;
        if(root.left != null) data += root.left.val;
        if(root.right != null) data += root.right.val;


        if(root.val != data && !isLeaf(root))
            return false;
        if(!check(root.left))
            return false;
        if(!check(root.right))
            return false;
        return true;
    }

    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}