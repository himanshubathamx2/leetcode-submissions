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
    public void recoverTree(TreeNode root) {
        int[] violations = new int[1];
        TreeNode[] indexToSwap = new TreeNode[3];
        TreeNode[] prev = new TreeNode[1];
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
        prev[0] = dummy;
        dfs(root, violations, indexToSwap, prev);

        if(violations[0] == 1){
            int tmp = indexToSwap[0].val;
            indexToSwap[0].val = indexToSwap[1].val;
            indexToSwap[1].val = tmp;
        }   
        if(violations[0] == 2){
            int tmp = indexToSwap[0].val;
            indexToSwap[0].val = indexToSwap[2].val;
            indexToSwap[2].val = tmp;
        }
    }

    public void dfs(TreeNode root, int[] violations, TreeNode[] indexToSwap, TreeNode[] prev){
        if(root == null)
            return;
        dfs(root.left, violations, indexToSwap, prev);

        if(root.val < prev[0].val){
            violations[0]++;
            if(violations[0] == 1){
                indexToSwap[0] = prev[0];
                indexToSwap[1] = root;
            }
            if(violations[0] == 2){
                indexToSwap[2] = root;
            }
        }
        prev[0] = root;

        dfs(root.right, violations, indexToSwap, prev);
    }
}