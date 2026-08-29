class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);    
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Disconnect the left half from the right
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
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