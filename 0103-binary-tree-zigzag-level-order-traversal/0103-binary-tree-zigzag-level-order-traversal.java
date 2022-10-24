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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>  res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if(root != null) q.offer(root);
        int l = 0;
        while(!q.isEmpty()){
            int q_size = q.size();
            List<Integer> levels = new ArrayList<>();
            for(int i = 0; i < q_size;i++){
                TreeNode curr = q.poll();
                levels.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            if(l % 2 == 1){
                Collections.reverse(levels);
            }
            l++;
            res.add(levels);
        }
        return res;
    }
}