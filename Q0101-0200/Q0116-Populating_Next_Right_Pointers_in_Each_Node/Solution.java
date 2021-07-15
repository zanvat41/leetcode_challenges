/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;

        Node leftmost = root;

        // if leftmost.left == null, we are in the last level
        while(leftmost.left != null) {
            Node head = leftmost;

            while(head != null) {
                // Connect left child to right child
                head.left.next = head.right;

                // Connect right child to next's left child
                if(head.next != null)
                    head.right.next = head.next.left;

                // Go to the next node on the same level
                head = head.next;
            }

            // Go to next level
            leftmost = leftmost.left;

        }

        return root;
    }
}
