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
    private int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return maxLen;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int inc = 1, dec = 1;

        if (node.left != null) {
            int[] left = dfs(node.left);
            if (node.val + 1 == node.left.val) inc = left[0] + 1;
            if (node.val - 1 == node.left.val) dec = left[1] + 1;
        }

        if (node.right != null) {
            int[] right = dfs(node.right);
            if (node.val + 1 == node.right.val) inc = Math.max(inc, right[0] + 1);
            if (node.val - 1 == node.right.val) dec = Math.max(dec, right[1] + 1);
        }

        maxLen = Math.max(maxLen, inc + dec - 1);

        return new int[]{inc, dec};
    }
}