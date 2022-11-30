/*
 Runtime Complexity - O(n)
 Runtime - 5 ms
 Memory - 48.2 MB
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result, last;
        result = last = null;
        int temp;
        while( l1 != null && l2 != null ){
            temp = l1.val + l2.val + carry;
            carry = temp > 9 ? 1 : 0;
            temp %= 10;
            if( result == null ){
                result = new ListNode(temp);
                last = result;
            }
            else{
                last.next = new ListNode(temp);
                last = last.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        for(ListNode l : Arrays.asList(l1, l2)){
            while( l != null ){
                temp = carry + l.val;
                carry = temp > 9 ? 1 : 0;
                temp %= 10;
                last.next = new ListNode(temp);
                last = last.next;
                l = l.next;
            }
        }
        if(carry > 0){
            last.next = new ListNode(carry);
            last = last.next;
        }
        return result;
    }
}
