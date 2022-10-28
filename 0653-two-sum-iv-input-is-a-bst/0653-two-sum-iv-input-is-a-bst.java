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
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        return helper(root,k,map);
    }
    public boolean helper(TreeNode root, int k, Map<Integer,Integer> map){
        if(root == null) return false;
        boolean left = false;
        boolean right = false;
        if(map.containsKey(root.val)) return true;
        else{
            map.put(k - root.val,root.val);
            left = helper(root.left,k,map);
            right =  helper(root.right,k,map);
        }
        return left || right;
    }
}