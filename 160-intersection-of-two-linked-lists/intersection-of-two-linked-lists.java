/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
        while(tmp1 != null || tmp2 != null){
            if(tmp1 == null) tmp1 = headB;
            if(tmp2 == null) tmp2 = headA;

            if(tmp1 == tmp2)
                return tmp1;

            tmp1 = tmp1.next;
            tmp2 = tmp2.next; 
           
        }
        return null;
    }
}