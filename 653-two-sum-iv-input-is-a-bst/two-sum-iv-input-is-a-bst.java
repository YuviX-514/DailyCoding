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
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        in(root);
        int i  =0;
        int j = list.size()-1;
        while(i < j){
            if(list.get(i) + list.get(j) == k)return true;
            else if(list.get(i) + list.get(j) > k)j--;
            else i++;
        }
        return false;
        
    }

    public void in(TreeNode root){
        if(root == null)return;
        in(root.left);
        list.add(root.val);
        in(root.right);
    }
}