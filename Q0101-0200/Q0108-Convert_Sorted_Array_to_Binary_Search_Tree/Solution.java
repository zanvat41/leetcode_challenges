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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;

        int low = 0, high = nums.length - 1;

        return buildBST(nums, low, high);
    }

    TreeNode buildBST(int[] nums, int low, int high) {
        if(low > high) return null;
        int mid = (low + high) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = buildBST(nums, low, mid - 1);
        res.right = buildBST(nums, mid + 1, high);
        return res;
    }
}