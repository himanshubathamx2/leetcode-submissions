class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add first node of every list
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            curr.next = node;
            curr = node;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}