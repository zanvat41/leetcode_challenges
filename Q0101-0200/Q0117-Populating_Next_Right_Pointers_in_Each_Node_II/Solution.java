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

        if(root == null)
            return null;

        Node return_node = root;
        Node dummyHead = new Node(0);
        Node prev = dummyHead;

        while(root != null)
        {
            if(root.left != null)
            {
                prev.next = root.left;
                prev = prev.next;

            }

            if(root.right != null)
            {

                prev.next = root.right;
                prev = prev.next;

            }

            // Go to next node on the same level
            root = root.next;

            // Go to next level
            if(root == null)
            {
                root = dummyHead.next;
                prev = dummyHead;
                dummyHead.next = null;
            }


        }


        return return_node;
    }
}
