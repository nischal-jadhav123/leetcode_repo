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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        Deque<TreeNode> st = new ArrayDeque<>();
        Deque<Integer> diff = new ArrayDeque<>();
        st.push(root);
        diff.push(root.val);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            int val = diff.pop();
            if(curr.left == null && curr.right == null && sum == val ) return true;
            else{
               if(curr.left != null){
                st.push(curr.left);
                diff.push(curr.left.val+val);
            }
              if(curr.right != null){
                st.push(curr.right);
                diff.push(curr.right.val+val); 
            } 
            }
            
        }
        return false;
    }
}