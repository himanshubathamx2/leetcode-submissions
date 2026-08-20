/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Pair{
    TreeNode node;
    int dis;
    Pair(TreeNode node, int dis){
        this.node = node;
        this.dis = dis;
    }
}

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        findParents(root, map);
        map.put(root, null);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(target, 0));
        Set<TreeNode> set = new HashSet<>();
        while(!q.isEmpty()){
            Pair popped = q.poll();
            TreeNode node = popped.node;
            int dis = popped.dis;
            set.add(node);
            if(dis == k)
                ans.add(node.val);
            if(node.left != null && !set.contains(node.left)) q.offer(new Pair(node.left, dis + 1));
            if(node.right != null && !set.contains(node.right)) q.offer(new Pair(node.right, dis + 1));
            if(map.get(node) != null && !set.contains(map.get(node)))q.offer(new Pair(map.get(node), dis + 1));  
        }
        return ans;
    }

    public void findParents(TreeNode root, Map<TreeNode, TreeNode> map){
        if(root == null)
            return;
        if(root.left != null) map.put(root.left, root);
        if(root.right != null) map.put(root.right, root);
        findParents(root.left, map);
        findParents(root.right, map); 
    }
}