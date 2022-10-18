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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Stack<List<Integer>> levels = new Stack<>();
        if(root != null) {
            nodeQueue.offer(root);
        }
        while(!nodeQueue.isEmpty()) {
            int qSize = nodeQueue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = nodeQueue.poll();
                level.add(curr.val);
                if(curr.left != null) nodeQueue.offer(curr.left);
                if(curr.right != null) nodeQueue.offer(curr.right);
            }
            levels.push(level);
        }

        List<List<Integer>> res = new ArrayList<>();
        while(!levels.isEmpty()) {
            res.add(levels.pop());
        }
        return res;
    }
}