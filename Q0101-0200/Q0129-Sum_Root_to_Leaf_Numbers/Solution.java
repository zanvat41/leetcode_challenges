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
    public int sumNumbers(TreeNode root) {
        //return 0;
        return helper(root, root.val);
    }

    private int helper(TreeNode node, int sum) {
        if(node.left == null && node.right == null) return sum;
        int left = 0, right = 0;
        if(node.left != null)
            left = helper(node.left, 10 * sum + node.left.val);
        if(node.right != null)
            right = helper(node.right, 10*sum + node.right.val);
        return left + right;

    }
}
