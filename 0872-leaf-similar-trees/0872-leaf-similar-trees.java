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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        helper(root1,l1);
        helper(root2,l2);
        if(l1.size() == l2.size()){
            for(int i = 0; i < l1.size();i++){
                if(l1.get(i) != l2.get(i)) return false;
            }
            return true;
        }
        return false;
    }
    public void helper(TreeNode root,List<Integer> l){
        if(root == null) return;
        if(root.left == null && root.right == null) l.add(root.val);
        if(root.left != null) helper(root.left,l);
        if(root.right != null) helper(root.right,l);
    }
}