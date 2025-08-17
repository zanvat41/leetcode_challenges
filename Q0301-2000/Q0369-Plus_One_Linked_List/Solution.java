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
    public ListNode plusOne(ListNode head) {
        // Key idea is to find the rightmost not-nine digit,
        // increase that digit by 1, and set all digits on the
        // right(all should be 9s) of that digit to be 0s

        // in case of numbers with digit 9s only, we add a 0
        // in the front
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode notNine = res;

        // find the rightmost not-nine digit
        while(head != null) {
            if (head.val != 9) {
                notNine = head;
            }
            head = head.next;
        }

        notNine.val++;

        notNine = notNine.next;
        while(notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }

        return res.val != 0 ? res : res.next;
    }
}