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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int c = 0;
            List<Integer> list = new ArrayList<>();
            while(size != c){
                TreeNode popped = q.poll();
                c++;
                list.add(popped.val);
                if(popped.left != null) q.offer(popped.left);
                if(popped.right != null) q.offer(popped.right);
            }
            ans.add(list);
        }
        return ans;
    }
}