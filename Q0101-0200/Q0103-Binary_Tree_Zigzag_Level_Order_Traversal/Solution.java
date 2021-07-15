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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode node, int lvl) {
        if(node == null) return;
        if(res.size() == lvl)
            res.add(new ArrayList<Integer>());

        if(lvl % 2 == 0)
            res.get(lvl).add(node.val);
        else
            res.get(lvl).add(0, node.val);

        helper(res, node.left, lvl + 1);
        helper(res, node.right, lvl + 1);
    }
}
