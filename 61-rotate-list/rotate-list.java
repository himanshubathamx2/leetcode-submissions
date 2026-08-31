
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0)
            return head;
        ListNode tmp = head;
        int len = findLen(tmp);
        k = k % len;
        if(k==0)
            return head;
        int i = 0;
        while(i < len - k - 1){
            i++;
            tmp = tmp.next;
        }
        ListNode newHead = tmp.next;
        tmp.next = null;
        ListNode tail = findTail(newHead);
        tail.next = head;
        return newHead;
    }

    public int findLen(ListNode head){
        int i = 0;
        while(head != null){
            i++;
            head = head.next;
        }
        return i;
    }

    public ListNode findTail(ListNode head){
        while(head.next != null){
            head = head.next;
        }
        return head;
    }
}