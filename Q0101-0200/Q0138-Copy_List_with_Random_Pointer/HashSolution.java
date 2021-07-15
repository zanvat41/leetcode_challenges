/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class HashSolution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();
        Node cur = head;
        Node res = new Node(-1);
        Node curRes = res;
        while(cur != null) {
            curRes.next = new Node(cur.val);
            map.put(cur, curRes.next);
            cur = cur.next;
            curRes = curRes.next;
        }
        cur = head;
        curRes = res.next;
        while(cur != null) {
            if(cur.random != null) {
                curRes.random = map.get(cur.random);
            }
            cur = cur.next;
            curRes = curRes.next;
        }

        return res.next;

    }
}
