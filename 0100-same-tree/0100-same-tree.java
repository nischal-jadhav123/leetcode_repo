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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        boolean e = false;
        if(p != null && q != null && p.val == q.val)
            e = true;
        boolean l = false, r = false;
        if(e){
            l = isSameTree(p.left,q.left);
            r = isSameTree(p.right,q.right);
        }
        return e && l && r;
    }
}