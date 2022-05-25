package linkedlist_;
public class LinkedList_19 {

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        //快比慢多 n 步
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //此时 fast 为链表尾
        //slow 是要删除的节点前驱
        /*
        假如：
        n = 1时【tail表示链表尾的 指代 】
        fast = tail
        slow = tail - 1
        要删除节点为 tail
         */
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }

}