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
    int d = -1;
    TreeNode p = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        return helper(root,x,y,null,0);
    }
    private boolean helper(TreeNode root, int x, int y, TreeNode parent, int depth){
        if(root == null) return false;
        if(root.val == x || root.val == y){
            if(d == -1){
                d = depth;
                p = parent;
            }else{
                if(p == parent || d != depth) return false;
                else return true;
            }
        }
        return helper(root.left,x,y,root,depth+1) || helper(root.right,x,y,root,depth+1);
    }
}