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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        if(root != null) q.offer(root);
        while(!q.isEmpty()){
            List<Integer> curr = new ArrayList<>();
            double q_size = q.size(),row = 0;
            for(int i = 0; i < q_size;i++){
                TreeNode t = q.poll();
                row += t.val;
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            res.add(row/q_size);
        }
        return res;
    }
}