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
    Map<Integer, Integer> map = new HashMap<>();
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        index = postorder.length - 1;

        for (int i = 0; i < inorder.length; ++i)
        {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] postorder, int low, int high)
    {
        if (low > high)
        {
            return null;
        }

        //if (low == high)
        //{
        //    return new TreeNode(postorder[index--]);
        //}

        TreeNode node = new TreeNode(postorder[index--]);

        int in = map.get(node.val);
        node.right = build(postorder, in + 1, high);
        node.left = build(postorder, low, in - 1);
        return node;
    }
}
