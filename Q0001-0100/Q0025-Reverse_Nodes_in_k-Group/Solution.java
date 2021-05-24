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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;
        ListNode res = null;
        ListNode lastend = new ListNode(-1, head);

        while(end != null) {
            int i = 0;
            //end = start;
            while (i < k && end != null) {
                end = end.next;
                i++;
            }
            if(i == k) {
                ListNode rev = reverseList(start, k);

                if (res == null) res = rev;

                lastend.next = rev;
                lastend = start;
                start = end;
                //System.out.println(lastend.val);
                //System.out.println(lastend.next.val);
                //System.out.println(start.val);
            }
        }

        lastend.next = start;

        return res == null ? head : res;
    }

    private ListNode reverseList(ListNode head, int k) {
        ListNode res = null;
        ListNode cur = head;

        while (k > 0) {
            //System.out.println(k+","+cur.val+","+cur.next);
            ListNode next = cur.next;
            cur.next = res;
            res = cur;
            cur = next;
            k--;
        }
        return res;
    }
}
