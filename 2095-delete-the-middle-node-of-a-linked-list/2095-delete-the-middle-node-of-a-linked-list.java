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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        ListNode p = null, q = head;
        while(q != null && q.next != null){
            if(p == null){
                p = head;
            }else{
                p = p.next;
            }
            q = q.next.next;
        }
        if(p.next != null) p.next = p.next.next;
        return head;
    }
}