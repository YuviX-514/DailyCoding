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
    public void recoverTree(TreeNode root) {
        in(root);
        Collections.sort(list);
        tree(root);
    }

    public void in(TreeNode root){
        if(root == null)return ;
        in(root.left);
        list.add(root.val);
        in(root.right);
    }
    public void tree(TreeNode root){
        if(root == null)return ;
        tree(root.left);
        root.val = list.remove(0);
        tree(root.right);
    }






}