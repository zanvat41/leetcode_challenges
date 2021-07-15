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
class ListSolution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        int n = 0;
        List<ListNode> list = new ArrayList();
        ListNode cur = head;
        while(cur != null){
            list.add(cur);
            cur = cur.next;
            n++;
        }

        int l = 0, r = n - 1;
        while(l < r){
            ListNode left = list.get(l);
            ListNode right = list.get(r);
            right.next = left.next;
            left.next = right;
            l++;
            r--;
        }

        list.get(l).next = null;

    }
}
