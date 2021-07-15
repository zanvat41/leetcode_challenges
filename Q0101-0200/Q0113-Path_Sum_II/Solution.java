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
    List<List<Integer>> res;


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList();
        pathSum(root, targetSum, new ArrayList<Integer>());
        return res;
    }


    private void pathSum(TreeNode root, int sum, List<Integer> path) {
        if (root == null) return;

        sum -= root.val;
        path.add(root.val);
        if ((root.left == null) && (root.right == null)){
            if(sum == 0) res.add(new ArrayList<>(path));
        } else{
            pathSum(root.left, sum, path);
            pathSum(root.right, sum, path);
        }
        path.remove(path.size() - 1);
    }
}
