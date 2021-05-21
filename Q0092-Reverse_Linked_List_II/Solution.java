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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode first = new ListNode(-1, head);
        for(int i = 1; i < left; i++) {
            first = first.next;
        }

        ListNode last = first.next;
        for(int i = left; i <= right; i++){
            last = last.next;
        }

        first.next = reverseList(first.next, right - left + 1);

        ListNode second = first;
        for(int i = left; i <= right; i++){
            second = second.next;
        }
        second.next = last;
        if(left == 1)
            return first.next;
        else
            return head;
    }

    public ListNode reverseList(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null && n > 0) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
            n--;
        }
        return prev;


    }
}
