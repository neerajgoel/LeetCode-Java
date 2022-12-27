/* 
 -- In-place algorithm
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Memory - 42.1 MB
*/

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

    class Pair{
        ListNode first, second;
        Pair(ListNode _f, ListNode _s){
            this.first = _f;
            this.second = _s;
        }
    }

    private Pair reverseListIntrl(ListNode head) {
        if( head == null ){
            return null;
        }
        Pair reversedList = reverseListIntrl( head.next );
        head.next = null;
        if( reversedList == null ){
            return new Pair(head, head);
        }
        reversedList.second.next = head;
        return new Pair( reversedList.first, head);
    }

    public ListNode reverseList(ListNode head) {
        Pair resultPair = reverseListIntrl( head );
        if( resultPair == null ){
            return null;
        }
        return resultPair.first;
    }

}
