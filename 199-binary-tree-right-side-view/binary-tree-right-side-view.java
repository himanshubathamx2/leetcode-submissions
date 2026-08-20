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
    int level;
    TreeNode node;
    Pair(int level, TreeNode node){
        this.level = level;
        this.node = node;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        q.offer(new Pair(0, root));
        while(!q.isEmpty()){
            Pair popped = q.poll();
            TreeNode node = popped.node;
            int level = popped.level;
            map.put(level, node.val);
            if(node.left != null) q.offer(new Pair(level + 1, node.left));
            if(node.right != null) q.offer(new Pair(level + 1, node.right));
        }
        for(int node : map.values()){
            ans.add(node);
        }
        return ans;
    }
}