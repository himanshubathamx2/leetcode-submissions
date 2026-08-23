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
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode mid = findMid(head);
        ListNode revHead = revLL(mid.next);
        ListNode tmp  = head ;
        while(revHead != null){
            if(revHead.val != tmp.val)
                return false;
            revHead = revHead.next;
            tmp = tmp.next;    
        }
        return true;
    }

    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode revLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}