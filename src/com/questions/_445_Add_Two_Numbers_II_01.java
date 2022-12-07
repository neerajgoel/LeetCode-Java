/*
 Runtime Complexity - O(n)
 Runtime - 4 ms
 Memory - 48.5 MB
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

    private int findLength(ListNode l1){
        int count = 0;
        while( l1 != null ){
            count++;
            l1 = l1.next;
        }
        return count;
    }

    private ListNode insertLeadingZeros(ListNode l1, int count){
        while ( count-- > 0){
            ListNode tmp = new ListNode(0);
            tmp.next = l1;
            l1 = tmp;
        }
        return l1;
    }

    class Pair{
        ListNode list;
        int carry;
    }

    private Pair process(ListNode l1, ListNode l2){
        if( l1 == null ){
            return null;
        }
        Pair tail = process(l1.next, l2.next);
        int sum = l1.val + l2.val;
        if( tail != null ){
            sum += tail.carry;
        }
        ListNode tmp = new ListNode( sum % 10 );
        tmp.next = tail == null ? null : tail.list;

        Pair pair  = new Pair();
        pair.carry = sum > 9 ? 1 : 0;
        pair.list = tmp;
        return pair;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c1 = findLength(l1);
        int c2 = findLength(l2);
        if( c1 > c2 ){
            // insert leading zeros in front of l2
            l2 = insertLeadingZeros(l2, c1 - c2);
        }
        else if( c2 > c1 ){
            // insert leading zeros in front of l1
            l1 = insertLeadingZeros(l1, c2 - c1);
        }
        
        Pair result = process(l1, l2);
        if( result.carry > 0 ){
            ListNode tmp = new ListNode(1);
            tmp.next = result.list;
            result.list = tmp;
        }
        return result.list;
    }
}
