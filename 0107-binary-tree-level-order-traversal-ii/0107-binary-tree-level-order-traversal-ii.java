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
        List<List<Integer>> res = new ArrayList<>();
        Deque<List<Integer>> st = new ArrayDeque<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> curr = new ArrayList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp != null){
                curr.add(temp.val);
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }else{
            List<Integer> c_curr = new ArrayList<>(curr);
                st.push(c_curr);
                curr.clear();
                if(!q.isEmpty()) q.offer(null);
            }
        }
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        return res;
    }
}