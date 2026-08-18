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
class Triplet{
    int level;
    int ver;
    TreeNode node;
    Triplet(TreeNode node, int level, int ver){
        this.level = level;
        this.ver = ver;
        this.node = node;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        if(root == null)
            return ans;
        Queue<Triplet> q = new LinkedList<>();
        q.offer(new Triplet(root, 0, 0));
        while(!q.isEmpty()){
            Triplet popped = q.poll();
            TreeNode node = popped.node;
            int level = popped.level;
            int ver = popped.ver;
            if(!map.containsKey(ver))
                map.put(ver, new TreeMap<>());
            if(!map.get(ver).containsKey(level))
                map.get(ver).put(level, new PriorityQueue<>());
            map.get(ver).get(level).offer(node.val);
            if(node.left != null) q.offer(new Triplet(node.left, level + 1, ver - 1));
            if(node.right != null) q.offer(new Triplet(node.right, level + 1, ver + 1));
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> tmap : map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq : tmap.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;
    }
}