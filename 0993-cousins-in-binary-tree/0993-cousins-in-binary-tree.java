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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Deque<List<TreeNode>> q = new LinkedList<>();
        boolean res = false;
        List<TreeNode> arr = new ArrayList<>();
        arr.add(root);
        arr.add(root);
        q.offer(arr);
        while(!q.isEmpty()){
            int q_size = q.size();
            int found = 0, foundParent = -1;
            for(int i = 0; i < q_size;i++){
                List<TreeNode> r = q.poll();
                if(r.size() > 0){
                    TreeNode curr = r.get(0);
                    TreeNode parent = r.get(1);
                if(x == curr.val && found == 0){
                    found = 1;
                    foundParent = parent.val;
                }else if(x == curr.val && found == 1 && foundParent != parent.val){
                    return true;
                }else if(y == curr.val && found == 0){
                    found = 1;
                    foundParent = parent.val;
                }else if(y == curr.val && found == 1 && foundParent != parent.val){
                    return true;
                }
                    
                    if(curr.left != null){
                        List<TreeNode> arr1 = new ArrayList<>();
                        arr1.add(curr.left);
                        arr1.add(curr);
                        q.offer(arr1);
                    } 
                    if(curr.right != null){
                        List<TreeNode> arr2 = new ArrayList<>();
                        arr2.add(curr.right);
                        arr2.add(curr);
                        q.offer(arr2);
                    } 
                } 
            }
        }
        return false;
    }
}