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
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int c = 0;
        while(l1 != null || l2 != null){
            int sum = c;
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

            ListNode node = new ListNode(sum % 10);
            c = sum / 10;
            curr.next = node;
            curr = node;
        }

        if(c == 1){
            ListNode node = new ListNode(c);
            curr.next = node;
        }

        return dummy.next;
    }
}