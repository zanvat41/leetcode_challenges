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
    public ListNode partition(ListNode head, int x) {
        ListNode firstStart = new ListNode(0);
        ListNode first = firstStart;
        ListNode secondStart = new ListNode(0);
        ListNode second = secondStart;

        while(head != null) {
            if(head.val < x) {
                first.next = head;
                first = first.next;
            }
            else {
                second.next = head;
                second = second.next;
            }
            head = head.next;
        }


        second.next = null;
        first.next = secondStart.next;
        return firstStart.next;

    }
}
