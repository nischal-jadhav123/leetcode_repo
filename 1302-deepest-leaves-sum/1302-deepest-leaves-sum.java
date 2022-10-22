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
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int q_size = q.size();
            sum = 0;
            for(int i = 0; i < q_size;i++){
                TreeNode t = q.poll();
                sum += t.val;
                if(t.left != null) q.offer(t.left);
                if(t.right!= null) q.offer(t.right);
            }
        }
        return sum;
    }
}