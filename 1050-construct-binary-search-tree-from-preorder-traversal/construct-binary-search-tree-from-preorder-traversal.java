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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i = new int[1];
        return f(preorder, Integer.MAX_VALUE, i);
    }

    public TreeNode f(int[] preorder, int ub, int[] i){
        if(i[0] >= preorder.length || preorder[i[0]] > ub)
            return null;

        int val = preorder[i[0]++];
        TreeNode root = new TreeNode(val);
        root.left = f(preorder, val, i);
        root.right = f(preorder, ub, i);
        return root;
    }
    

}