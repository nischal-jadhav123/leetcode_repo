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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null){
            q.offer(root);
        }
        while(!q.isEmpty()){
            int q_size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < q_size;i++){
                TreeNode t = q.poll();
                if(t.val > max) max = t.val;
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            res.add(max);
        }
        return res;
    }
}