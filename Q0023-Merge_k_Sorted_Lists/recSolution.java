/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return lists[start];
        }

        // Divide
        int mid = start + (end - start) / 2;
        ListNode node1 = merge(lists, start, mid);
        ListNode node2 = merge(lists, mid + 1, end);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        // Conquer
        // Merge two list
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
                cur = cur.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
                cur = cur.next;
            }
        }

        if (node1 != null) {
            cur.next = node1;
        } else if (node2 != null) {
            cur.next = node2;
        }

        return dummy.next;
    }
}
