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
    TreeNode prev;
    // It's the large value put on the front
    // of the sorted array
    TreeNode first;
    // It's the small valuer put on the end
    // of the sorted array
    TreeNode second;

    public void recoverTree(TreeNode root) {
        if (root == null) return;

        // Do inorder traversal on the tree,
        // and find the two wapped nodes
        inOrder(root);

        // Swap the two nodes
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);

        if(prev != null && node.val < prev.val){
            second = node;
            if(first == null) first = prev;
            else return;
        }

        prev = node;

        inOrder(node.right);

    }
}
