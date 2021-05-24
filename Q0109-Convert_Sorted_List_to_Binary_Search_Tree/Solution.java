/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode p = new ListNode(0, head);
        while(p.next != null) {
            size ++;
            p = p.next;
        }

        this.head = head;

        return helper(0, size - 1);
    }

    private TreeNode helper(int start, int end) {
        if(start > end) return null;

        int mid = (start + end)/2;

        TreeNode left = helper(start, mid - 1);

        TreeNode node = new TreeNode(this.head.val, left, null);

        this.head = this.head.next;

        node.right = helper(mid + 1, end);

        return node;

    }
}
