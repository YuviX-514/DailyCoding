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
    public TreeNode bstFromPreorder(int[] preorder) {
        int in[] = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(in);

        return helper(in, 0, in.length-1, preorder, 0, preorder.length-1);

    }

    public TreeNode helper(int[]in, int ilo, int ihi, int[]pre, int plo, int phi){
        if(ilo > ihi || plo > phi)return null;

        TreeNode node = new TreeNode(pre[plo]);
        int idx = search(in, ilo, ihi, pre[plo]);
        int c = idx - ilo;

        node.left = helper(in, ilo, idx-1, pre, plo+1, plo+c);
        node.right = helper(in, idx + 1, ihi, pre, plo+c+1, phi);

        return node;

    }

    public int search(int[]in, int ilo, int ihi, int item){
        for(int i=ilo;i<=ihi;i++){
            if(in[i] == item)return i;
        }
        return 0;
    }
}