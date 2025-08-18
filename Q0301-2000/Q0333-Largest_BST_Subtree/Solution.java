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

class NodeValue {
    public int minNode, maxNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}

class Solution {
    public NodeValue largestBSTSubtreeHelper(TreeNode root) {
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);

        if(left.maxNode < root.val && root.val < right.minNode) {
            // valid BST
            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
                    left.maxSize + right.maxSize + 1);
        }
        else {
            // Otherwise, return [-inf, inf] so that parent can't be valid BST
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,
                    Math.max(left.maxSize, right.maxSize));
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        return largestBSTSubtreeHelper(root).maxSize;
    }
}