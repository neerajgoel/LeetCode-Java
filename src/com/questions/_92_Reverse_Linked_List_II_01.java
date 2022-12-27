/* 
 -- In-place algorithm
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Memory - 39.8 MB
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

    private Pair reverseListIntrl(ListNode head, int left, int right, int curr) {
        if( head == null ){
            return null;
        }
        if( curr >= right ){
            return new Pair(head, head);
        }
        Pair reversedList = reverseListIntrl( head.next, left, right, curr + 1 );
        if( reversedList == null ){
            head.next = null;
            return new Pair(head, head);
        }
        if( left <= curr ){
            head.next = reversedList.second.next;
            reversedList.second.next = head;
            return new Pair( reversedList.first, head);
        }
        head.next = reversedList.first;
        return new Pair( head, null);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if( head == null ){
            return null;
        }
        Pair resultPair = reverseListIntrl(head, left, right, 1);
        return resultPair.first;
    }
}
