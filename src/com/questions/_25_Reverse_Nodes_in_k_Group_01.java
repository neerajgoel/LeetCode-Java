/* 
 -- In-place algorithm
 Runtime Complexity - O(n)
 Runtime - 1 ms
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

    class Data{
        ListNode first, second;
        boolean doReverse = true;
        Data(ListNode _f, ListNode _s, boolean _doRev){
            this.first = _f;
            this.second = _s;
            this.doReverse = _doRev;
        }
    }

    private Data reverseIntrnl(ListNode head, int k, int curr){
        if( head == null ){
            return new Data(null, null, curr == 0);
        }
        if( curr <= 0 ){
            curr = k;
        }
        Data reverseData = reverseIntrnl( head.next, k, curr - 1);
        if( reverseData.first == null ){
            head.next = null;
            if( !reverseData.doReverse && curr == k ){
                reverseData.doReverse = true;
            }
            return new Data(head, head, reverseData.doReverse);
        }
        if( curr != 1 && reverseData.doReverse ){
            head.next = reverseData.second.next;
            reverseData.second.next = head;
            return new Data(reverseData.first, head, reverseData.doReverse);
        }
        head.next = reverseData.first;
        if( !reverseData.doReverse && curr == k ){
            reverseData.doReverse = true;
        }
        return new Data(head, head, reverseData.doReverse);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if( head == null ){
            return null;
        }
        Data resultData = reverseIntrnl(head, k, k);
        return resultData.first;
    }
}
