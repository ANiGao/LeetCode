package linkedlist_;
public class LinkedList_24 {

}
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
class Solution_24 {
    /**
     * @param head
     * @return
     *
     * 思路：
     *  链表本体 ： node1 node2 node3 ... node(n)
     *
     *      node3，4交换后  ... node2 node4 node3 node5...
     *      //需要前节点node2；
     *      cur = node2
     *      LN temp = node4.next
     *      cur.next = node4
     *      node4.next = node3
     *      node3.next = temp
     *
     */
    public ListNode swapPairs(ListNode head) {
        //第一次需要哨兵头节点，交换node1，2
        ListNode curHead = new ListNode(0);
        //head 一直指向 1 ，应该 return 它的前节点 2 ;
        curHead.next = head;
        ListNode pre = curHead;
        //
        // while 中 pre.next.next != null 不能在 pre.next != null 之前
        //会报找不到节点的错误
        while ( pre.next != null && pre.next.next != null){
            ListNode temp = head.next.next;
            //交换
            pre.next = head.next;
            head.next.next = head;
            head.next = temp;
            //排序前pre  head  head.next  head.next.next
            //排序后pre  head.next  head  head.next.next
            pre = head;
            head = temp;
        }
        return curHead.next;
    }


}
/**
 * 看题解的思路
 * 排序前pre  head  head.next  head.next.next
 * 排序后pre  head.next  head  head.next.next
 *                      pre   head
 */
//      ListNode temp = head.next.next; // 缓存 next
//      prev.next = head.next;          // 将 prev 的 next 改为 head 的 next
//      head.next.next = head;          // 将 head.next(prev.next) 的next，指向 head
//      head.next = temp;               // 将head 的 next 接上缓存的temp

//      prev = head;                    // 步进1位
//      head = head.next;