/*

Runtime - 1 ms
Memory - 40.3 MB
*/
public class _430_Flatten_a_Multilevel_Doubly_Linked_List_01 {

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


    public Node flatten(Node head) {
        if( head == null ){
            return null;
        }
        if( head.child != null ){
            // flatten child
            Node flattndChild  = flatten( head.child );
            if( head.next == null ){
                head.next = flattndChild;
                flattndChild.prev = head;
                head.child = null;
            }
            else{
                Node nextNode = head.next;
                head.next = flattndChild;
                flattndChild.prev = head;
                head.child = null;
                Node lastNode = null;
                while( flattndChild != null ){
                    lastNode = flattndChild;
                    flattndChild = flattndChild.next;
                }
                lastNode.next = nextNode;
                nextNode.prev = lastNode;
            }
        }
        flatten(head.next);
        return head;
    }
}
