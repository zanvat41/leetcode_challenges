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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode p1 = l1, p2 = l2, cur = res;
        int sum = 0;
        int extra = 0;
        while (p1 != null && p2 != null) {
            sum = (p1.val + p2.val + extra) % 10;
            extra = (p1.val + p2.val + extra) >= 10 ? 1 : 0;
            cur.next = new ListNode();
            cur.next.val = sum;
            cur = cur.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            sum = (p1.val + extra) % 10;
            extra = (p1.val + extra) >= 10 ? 1 : 0;
            cur.next = new ListNode();
            cur.next.val = sum;
            cur = cur.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            sum = (p2.val + extra) % 10;
            extra = (p2.val + extra) >= 10 ? 1 : 0;
            cur.next = new ListNode();
            cur.next.val = sum;
            cur = cur.next;
            p2 = p2.next;
        }

        if (extra == 1) {
            cur.next = new ListNode();
            cur.next.val = 1;
        }
        return res.next;
    }
}
