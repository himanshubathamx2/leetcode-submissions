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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode tmp1 = list1;
        ListNode tmp2 = list2;
        while(tmp1 != null && tmp2 != null){
            if(tmp1.val <= tmp2.val){
                curr.next = tmp1;
                curr = tmp1;
                tmp1 = tmp1.next;
            }else{
                curr.next = tmp2;
                curr = tmp2;
                tmp2 = tmp2.next;
            }
        }

        while(tmp1 != null){
            curr.next = tmp1;
            curr = tmp1;
            tmp1 = tmp1.next;
        }

        while(tmp2 != null){
            curr.next = tmp2;
            curr = tmp2;
            tmp2 = tmp2.next;
        }
        return dummy.next;
    }
}