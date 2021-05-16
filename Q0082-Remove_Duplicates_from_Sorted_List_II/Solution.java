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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0, head);

        ListNode cur = res;

        while(head != null) {
            // Check if this is start of duplicate elements
            if(head.next != null && head.val == head.next.val) {
                // move to the last duplicate element
                while(head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                cur.next = head.next;
                head = head.next;
            } else {
                cur = cur.next;
                head = head.next;
            }
        }
        return res.next;
    }
}
